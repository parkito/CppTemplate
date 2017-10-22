package com.karnov.crud.security;

import com.karnov.crud.entity.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Karnov @date 10/22/2017.
 * artem.karnov@t-systems.com
 */
public class TokenHolder {
    private static final Map<String, String> TOKEN_MAP = new HashMap<>();

    public static void addToken(Person person, TokenData tokenData) {
        String serializedToken = serializeTokenData(tokenData);
        TOKEN_MAP.put(person.getEmail(), serializedToken);
    }

    public static TokenData getTokenFromSessionForPerson(Person person) {
        return deserializeTokenData(TOKEN_MAP.get(person.getEmail()));
    }

    public static void clearTokenHolder() {
        TOKEN_MAP.clear();
    }

    private static String serializeTokenData(TokenData tokenData) {
        try (ByteArrayOutputStream bo = new ByteArrayOutputStream();
             ObjectOutputStream so = new ObjectOutputStream(bo)) {
            so.writeObject(tokenData);
            so.flush();
            return Base64.getEncoder().encodeToString(bo.toByteArray());
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static TokenData deserializeTokenData(String tokenDataString) {
        byte[] decodedToken = Base64.getDecoder().decode(tokenDataString);
        try (ByteArrayInputStream bi = new ByteArrayInputStream(decodedToken);
             ObjectInputStream si = new ObjectInputStream(bi)) {
            return (TokenData) si.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}