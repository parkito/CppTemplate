package ru.siksmfp.ejb.crud.repository.api;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Artem Karnov @date 7/9/2018.
 * @email artem.karnov@t-systems.com
 */
public abstract class GenericRepository<E, K extends Serializable> implements IGenericRepository<E, K> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<E> daoType;

    private int batchSize = 10;

    public GenericRepository() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.daoType = (Class<E>) pt.getActualTypeArguments()[0];
    }

    @Override
    public void save(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void batchSave(List<E> entityList) {
        int tableSize = entityList.size();
        for (int i = 0; i < tableSize; i += batchSize) {
            entityManager.getTransaction().begin();
            int lastIndex = (i + batchSize) < tableSize ? (i + batchSize) : tableSize;
            for (E currentEntity : entityList.subList(i, lastIndex)) {
                if (currentEntity != null)
                    entityManager.persist(currentEntity);
            }
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public E find(K key) {
        return entityManager.find(daoType, key);

    }

    @Override
    public void update(E entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(E entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<E> getAll() {
        return entityManager.createQuery("from " + daoType.getSimpleName()).getResultList();
    }

    @Override
    public void deleteAll() {
        long tableSize = countElements();
        for (int i = 0; i < tableSize; i += batchSize) {
            entityManager.getTransaction().begin();
            Query internalQuery = entityManager.createQuery("from " + daoType.getSimpleName());
            internalQuery.setFirstResult(0);
            internalQuery.setMaxResults(batchSize);
            List<E> list = internalQuery.getResultList();
            for (E e : list) {
                if (e != null)
                    entityManager.remove(e);
            }
            entityManager.getTransaction().commit();
        }
    }

    @Override
    public long countElements() {
        Query query = entityManager.createQuery("select count(1) from " + daoType.getSimpleName());
        return (long) query.getFirstResult();
    }
}
