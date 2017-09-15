package exception;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class EntityCreateException extends RuntimeException {

    public EntityCreateException() {
        super();
    }

    public EntityCreateException(String message) {
        super(message);
    }

    public EntityCreateException(Throwable cause) {
        super();
    }

    public EntityCreateException(String message, Throwable cause) {
        super(message, cause);
    }

}
