package repository.impl;

import entity.Result;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class ResultRepositoryImpl extends GenericRepositoryImpl<Result, Long> implements repository.api.ResultRepository {

    @Override
    public Result findResultById(Long id) {
        return null;
    }

    @Override
    public List<Result> findResultById(List<Long> ids) {
        return null;
    }
}
