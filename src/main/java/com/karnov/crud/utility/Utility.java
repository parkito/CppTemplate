package com.karnov.crud.utility;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class Utility {

    private Utility() {
        throw new IllegalStateException("Utility class can't be instanced");
    }

    public final static String encryptPassword(String password){
        return password;
    }
}
