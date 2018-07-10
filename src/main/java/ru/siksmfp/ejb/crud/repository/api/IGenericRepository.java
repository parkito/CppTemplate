package ru.siksmfp.ejb.crud.repository.api;

import java.io.Serializable;
import java.util.List;

/**
 * @author Artem Karnov @date 7/9/2018.
 * @email artem.karnov@t-systems.com
 */
public interface IGenericRepository<E, K extends Serializable> {

    void save(E e);

    void batchSave(List<E> e);

    E find(K k);

    void update(E e);

    void delete(E e);

    List<E> getAll();

    void deleteAll();

    long countElements();

}
