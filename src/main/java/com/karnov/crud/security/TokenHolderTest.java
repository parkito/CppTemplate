package com.karnov.crud.security;

import com.karnov.crud.entity.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.util.resources.TimeZoneNames;

import java.util.Date;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Artem Karnov @date 10/22/2017.
 * artem.karnov@t-systems.com
 */
class TokenHolderTest {

    @BeforeAll
    public static void setUp() {
        TokenHolder.clearTokenHolder();
    }

    @Test
    void tokenHolderTest() {
        Person person = new Person();
        person.setEmail("email");
        person.setPassword("password");

        Date currentDate = new Date();
        TimeZone timeZone = TimeZone.getDefault();
        TokenData tokenData = new TokenData();
        tokenData.setPerson(person);
        tokenData.setExpirationDate(currentDate);
        tokenData.setTimeZone(timeZone);

        TokenHolder.addToken(person, tokenData);
        TokenData tokenFromSession = TokenHolder.getTokenFromSessionForPerson(person);

        assertEquals(person, tokenFromSession.getPerson());
        assertEquals(currentDate, tokenFromSession.getExpirationDate());
        assertEquals(timeZone, tokenFromSession.getTimeZone());
    }

}