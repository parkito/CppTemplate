package repository.api;

import exception.EntityCreateException;
import exception.EntityDeleteException;
import exception.EntityUpdateException;
import exception.RepositoryException;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface GenericRepository<E, K> {

    void create(E entity) throws EntityCreateException;

    void create(List<E> entities) throws EntityCreateException;

    void delete(E entity) throws EntityDeleteException;

    void delete(List<E> entities) throws EntityDeleteException;

    List<E> getAll() throws RepositoryException;

    E find(K id) throws RepositoryException;

    List<E> find(List<K> id) throws RepositoryException;

    void update(E entity) throws EntityUpdateException;

    void update(List<E> entities) throws EntityUpdateException;

}
