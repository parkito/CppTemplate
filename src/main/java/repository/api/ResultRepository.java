package repository.api;

import entity.Result;
import exception.RepositoryException;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface ResultRepository extends GenericRepository<Result, Long> {

    Result findResultById(Long id) throws RepositoryException;

    List<Result> findResultById(List<Long> ids) throws RepositoryException;

}
