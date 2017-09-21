package com.karnov.crud.utility;

import com.karnov.crud.repository.api.PersonRepository;
import com.karnov.crud.repository.api.PuzzleRepository;
import com.karnov.crud.repository.api.QuestionRepository;
import com.karnov.crud.repository.api.ResultRepository;
import com.karnov.crud.repository.api.VariantRepository;
import com.karnov.crud.repository.impl.PersonRepositoryImpl;
import com.karnov.crud.repository.impl.PuzzleRepositoryImpl;
import com.karnov.crud.repository.impl.QuestionRepositoryImpl;
import com.karnov.crud.repository.impl.ResultRepositoryImpl;
import com.karnov.crud.repository.impl.VariantRepositoryImpl;
import com.karnov.crud.service.PersonService;
import com.karnov.crud.service.PuzzleService;
import com.karnov.crud.service.QuestionService;
import com.karnov.crud.service.ResultService;
import com.karnov.crud.service.VariantService;

/**
 * @author Artem Karnov @date 16.09.2017.
 * artem.karnov@t-systems.com
 */
public class DIContainer {

    //Repositories
    private static final PuzzleRepository PUZZLE_REPOSITORY = new PuzzleRepositoryImpl();
    private static final QuestionRepository QUESTION_REPOSITORY = new QuestionRepositoryImpl();
    private static final ResultRepository RESULT_REPOSITORY = new ResultRepositoryImpl();
    private static final PersonRepository PERSON_REPOSITORY = new PersonRepositoryImpl();
    private static final VariantRepository VARIANT_REPOSITORY = new VariantRepositoryImpl();

    //Services
    private static final PuzzleService PUZZLE_SERVICE = new PuzzleService();
    private static final QuestionService QUESTION_SERVICE = new QuestionService();
    private static final ResultService RESULT_SERVICE = new ResultService();
    private static final PersonService USER_SERVICE = new PersonService();
    private static final VariantService VARIANT_SERVICE = new VariantService();

    private DIContainer() {
        throw new IllegalStateException("DIContainer class can't be instanced");
    }


    public static PuzzleRepository puzzleRepositoryInstance() {
        return PUZZLE_REPOSITORY;
    }

    public static QuestionRepository questionRepositoryInstance() {
        return QUESTION_REPOSITORY;
    }

    public static ResultRepository resultRepositoryInstance() {
        return RESULT_REPOSITORY;
    }

    public static PersonRepository userRepositoryInstance() {
        return PERSON_REPOSITORY;
    }

    public static VariantRepository variantRepositoryInstance() {
        return VARIANT_REPOSITORY;
    }

    public static PuzzleService puzzleServiceInstance() {
        return PUZZLE_SERVICE;
    }

    public static QuestionService questionServiceInstance() {
        return QUESTION_SERVICE;
    }

    public static ResultService resultServiceInstance() {
        return RESULT_SERVICE;
    }

    public static PersonService userServiceInstance() {
        return USER_SERVICE;
    }

    public static VariantService variantServiceInstance() {
        return VARIANT_SERVICE;
    }

}
