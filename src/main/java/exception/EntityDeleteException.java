package exception;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class EntityDeleteException extends RuntimeException {

    public EntityDeleteException() {
        super();
    }

    public EntityDeleteException(String message) {
        super(message);
    }

    public EntityDeleteException(Throwable cause) {
        super();
    }

    public EntityDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

}
