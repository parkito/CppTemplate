package com.karnov.crud.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;

/**
 * @author Artem Karnov @date 10/13/2017.
 * artem.karnov@t-systems.com
 */
public class ErrorMessageHolder {
    private int MAP_KEY = 0;

    private Map<String, List<String>> errors = new HashMap<>();

    public static ErrorMessageHolder Instance() {
        return new ErrorMessageHolder();
    }

    public void addMessage(String message) {
        errors.put(String.valueOf(MAP_KEY++), singletonList(message));
    }

    public void addMessage(String parameter, String message) {
        errors.put(parameter, singletonList(message));
    }

    public boolean isErrorsExists() {
        return !errors.isEmpty();
    }

    public Map<String, List<String>> getMessages() {
        return errors;
    }
}
