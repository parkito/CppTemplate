package utility;

import repository.api.PuzzleRepository;
import repository.api.QuestionRepository;
import repository.api.ResultRepository;
import repository.api.UserRepository;
import repository.api.VariantRepository;
import repository.impl.PuzzleRepositoryImpl;
import repository.impl.QuestionRepositoryImpl;
import repository.impl.ResultRepositoryImpl;
import repository.impl.UserRepositoryImpl;
import repository.impl.VariantRepositoryImpl;
import service.PuzzleService;
import service.QuestionService;
import service.ResultService;
import service.UserService;
import service.VariantService;

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
