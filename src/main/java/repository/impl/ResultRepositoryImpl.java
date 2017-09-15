package repository.impl;

import entity.Result;
import repository.api.QuestionRepository;
import repository.api.ResultRepository;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class ResultRepositoryImpl extends GenericRepositoryImpl<Result, Long> implements repository.api.ResultRepository {

    private static final ResultRepository REPO;

    static {
        REPO = new ResultRepositoryImpl();
    }

    public static ResultRepository getInstance() {
        return REPO;
    }

}
