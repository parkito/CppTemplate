package com.karnov.crud.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonList;

/**
 * @author Artem Karnov @date 10/13/2017.
 * artem.karnov@t-systems.com
 */
public class ErrorMessageHolder {
    private static final String EMPTY_KEY = "";
    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private Map<String, List<String>> errors = new HashMap<>();

    public static ErrorMessageHolder Instance() {
        return new ErrorMessageHolder();
    }

    public void addMessage(String message) {
        errors.put(EMPTY_KEY, singletonList(message));
    }

    public void addMessage(String parameter, String message) {
        errors.put(parameter, singletonList(message));
    }

    public String getMessages() {
        try {
            return OBJECT_MAPPER.writeValueAsString(errors);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return EMPTY_KEY;
        }
    }
}
