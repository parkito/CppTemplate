package repository.impl;

import entity.Question;
import repository.api.QuestionRepository;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class QuestionRepositoryImpl extends GenericRepositoryImpl<Question, Long> implements repository.api.QuestionRepository {

    private static final QuestionRepository REPO;

    static {
        REPO = new QuestionRepositoryImpl();
    }

    public static QuestionRepository getInstance() {
        return REPO;
    }

}
