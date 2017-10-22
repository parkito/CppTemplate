package com.karnov.crud.repository.impl;

import com.karnov.crud.exception.EntityCreateException;
import com.karnov.crud.exception.EntityDeleteException;
import com.karnov.crud.exception.EntityUpdateException;
import com.karnov.crud.exception.RepositoryException;
import com.karnov.crud.repository.api.GenericRepository;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public abstract class GenericRepositoryImpl<E, K> implements GenericRepository<E, K> {

    private Class<E> daoType;
    private static final EntityManagerFactory sessionFactory;

    protected static final EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory sessionFactoryInstance() {
        return sessionFactory;
    }

    public GenericRepositoryImpl() {
        daoType = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    @Transactional
    public void create(E entity) throws EntityCreateException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new EntityCreateException("Entity wasn't created: " + entity, ex);
        }
    }

    @Override
    @Transactional
    public void create(List<E> entities) throws EntityCreateException {
        try {
            entityManager.getTransaction().begin();
            for (E entity : entities) {
                entityManager.persist(entity);
            }
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new EntityCreateException("Entities weren't created: " + entities, ex);
        }
    }

    @Override
    @Transactional
    public void delete(E entity) throws EntityDeleteException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.merge(entity));
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new EntityDeleteException("Entity wasn't deleted: " + entity, ex);
        }
    }

    @Override
    @Transactional
    public void delete(List<E> entities) throws EntityDeleteException {
        try {
            entityManager.getTransaction().begin();
            for (E entity : entities) {
                entityManager.remove(entityManager.merge(entity));
            }
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new EntityDeleteException("Entities weren't deleted: " + entities, ex);
        }
    }

    @Override
    @Transactional
    public List<E> getAll() throws RepositoryException {
        try {
            entityManager.getTransaction().begin();
                List<E> result = entityManager.createNamedQuery(daoType.getSimpleName() + ".getAll", daoType).getResultList();
            entityManager.getTransaction().commit();
            return result;
        } catch (PersistenceException ex) {
            throw new RepositoryException("Entities weren't found", ex);
        }
    }

    @Override
    @Transactional
    public E find(K id) throws RepositoryException {
        try {
            entityManager.getTransaction().begin();
            E result = entityManager.find(daoType, id);
            entityManager.getTransaction().commit();
            return result;
        } catch (PersistenceException ex) {
            throw new RepositoryException("Entity " + id + " wasn't found", ex);
        }
    }

    @Override
    @Transactional
    public List<E> find(List<K> id) throws RepositoryException {
        try {
            entityManager.getTransaction().begin();
            List<E> result = (List<E>) entityManager.find(daoType, id);
            entityManager.getTransaction().commit();
            return result;
        } catch (PersistenceException ex) {
            throw new RepositoryException("Entities " + id + " wasn't found", ex);
        }
    }

    @Override
    @Transactional
    public void update(E entity) throws EntityUpdateException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new EntityUpdateException("Entity wasn't updated: " + entity, ex);
        }
    }

    @Override
    @Transactional
    public void update(List<E> entities) throws EntityUpdateException {
        try {
            entityManager.getTransaction().begin();
            for (E entity : entities) {
                entityManager.merge(entity);
            }
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new EntityUpdateException("Entities weren't updated: " + entities, ex);
        }
    }

}
