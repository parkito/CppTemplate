package com.karnov.crud.utility;

import com.karnov.crud.repository.api.PuzzleRepository;
import com.karnov.crud.repository.api.QuestionRepository;
import com.karnov.crud.repository.api.ResultRepository;
import com.karnov.crud.repository.api.UserRepository;
import com.karnov.crud.repository.api.VariantRepository;
import com.karnov.crud.repository.impl.PuzzleRepositoryImpl;
import com.karnov.crud.repository.impl.QuestionRepositoryImpl;
import com.karnov.crud.repository.impl.ResultRepositoryImpl;
import com.karnov.crud.repository.impl.UserRepositoryImpl;
import com.karnov.crud.repository.impl.VariantRepositoryImpl;
import com.karnov.crud.service.PuzzleService;
import com.karnov.crud.service.QuestionService;
import com.karnov.crud.service.ResultService;
import com.karnov.crud.service.UserService;
import com.karnov.crud.service.VariantService;

/**
 * @author Artem Karnov @date 16.09.2017.
 * artem.karnov@t-systems.com
 */
public class DIContainer {

    //Repositories
    private static final PuzzleRepository puzzleRepository = new PuzzleRepositoryImpl();
    private static final QuestionRepository questionRepository = new QuestionRepositoryImpl();
    private static final ResultRepository resultRepository = new ResultRepositoryImpl();
    private static final UserRepository userRepository = new UserRepositoryImpl();
    private static final VariantRepository variantRepository = new VariantRepositoryImpl();

    //Services
    private static final PuzzleService puzzleService = new PuzzleService();
    private static final QuestionService questionService = new QuestionService();
    private static final ResultService resultService = new ResultService();
    private static final UserService userService = new UserService();
    private static final VariantService variantService = new VariantService();

    private DIContainer() {
        throw new IllegalStateException("DIContainer class can't be instanced");
    }


    public static PuzzleRepository puzzleRepositoryInstance() {
        return puzzleRepository;
    }

    public static QuestionRepository questionRepositoryInstance() {
        return questionRepository;
    }

    public static ResultRepository resultRepositoryInstance() {
        return resultRepository;
    }

    public static UserRepository userRepositoryInstance() {
        return userRepository;
    }

    public static VariantRepository variantRepositoryInstance() {
        return variantRepository;
    }

    public static PuzzleService puzzleServiceInstance() {
        return puzzleService;
    }

    public static QuestionService questionServiceInstance() {
        return questionService;
    }

    public static ResultService resultServiceInstance() {
        return resultService;
    }

    public static UserService userServiceInstance() {
        return userService;
    }

    public static VariantService variantServiceInstance() {
        return variantService;
    }

}
