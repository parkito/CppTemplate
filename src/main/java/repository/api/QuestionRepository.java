package repository.api;

import entity.Question;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface QuestionRepository extends GenericRepository<Question, Long> {

    Question findQuestionById(long id);

}
