package com.karnov.crud.security;

import com.karnov.crud.entity.Person;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Artem Karnov @date 10/22/2017.
 * artem.karnov@t-systems.com
 */
public class TokenData implements Serializable {
    private Date expirationDate;
    private TimeZone timeZone;
    private Person person;

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
