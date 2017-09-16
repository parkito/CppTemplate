package com.karnov.crud.exception;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class EntityUpdateException extends RuntimeException {

    public EntityUpdateException() {
        super();
    }

    public EntityUpdateException(String message) {
        super(message);
    }

    public EntityUpdateException(Throwable cause) {
        super();
    }

    public EntityUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

}
