package repository.api;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface GenericRepository<E, K> {

    void create(E entity);

    void create(List<E> entities);

    void delete(E entity);

    void delete(List<E> entities);

    List<E> getAll();

    void update(E entity);

    void update(List<E> entities);

}
