package com.karnov.crud.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static com.karnov.crud.utility.Utility.encryptPassword;
import static org.junit.jupiter.api.Assertions.*;

class UtilityTest {

    @Test
    public void encryptAlgorithmCorrectionTest() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String password = "password";
        String encryptPassword = encryptPassword(password);
        boolean isPasswordValid = Utility.validatePassword(password, encryptPassword);

        assertEquals(true, isPasswordValid);
    }

    @Test
    public void encryptAlgorithmFailTest() throws InvalidKeySpecException, NoSuchAlgorithmException {
        String password1 = "password1";
        String password2 = "password2";
        String encryptPassword2 = encryptPassword(password2);
        boolean isPasswordValid = Utility.validatePassword(password1, encryptPassword2);

        assertEquals(false, isPasswordValid);
    }
}