package com.karnov.crud.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageJsonWriter {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static void writeObjectToPage(Object object, HttpServletResponse response) {
        response.setContentType("application/json");
        try {
            MAPPER.writeValue(response.getOutputStream(), object);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}