package com.karnov.crud.service;

import com.karnov.crud.entity.Question;
import com.karnov.crud.entity.Variant;
import com.karnov.crud.exception.EntityCreateException;
import com.karnov.crud.repository.api.QuestionRepository;

import static com.karnov.crud.utility.DIContainer.questionRepositoryInstance;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class QuestionService {

    private QuestionRepository questionRepository = questionRepositoryInstance();

    public boolean addVariant(Question question, String variantText, boolean isVariantCorrect) {
        Variant variant = new Variant();
        variant.setQuestion(question);
        variant.setVariantText(variantText);
        variant.setVariantIsCorrect(isVariantCorrect);

        question.getVariants().add(variant);

        try {
            questionRepository.create(question);
            return true;
        } catch (EntityCreateException ex) {
            return false;
        }
    }

    public boolean removeVariant(Question question, Variant variant) {
        question.getVariants().remove(variant);
        return persistUpdateQuesting(question);
    }

    public boolean updateVariant(Question question, Variant oldVariant, Variant newVariant) {
        question.getVariants().remove(oldVariant);
        question.getVariants().add(newVariant);
        return persistUpdateQuesting(question);
    }

    private boolean persistUpdateQuesting(Question question) {
        try {
            questionRepository.update(question);
            return true;
        } catch (EntityCreateException ex) {
            return false;
        }
    }

}
