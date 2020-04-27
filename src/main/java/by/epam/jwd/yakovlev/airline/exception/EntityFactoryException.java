package by.epam.jwd.yakovlev.airline.exception;

public class EntityFactoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public EntityFactoryException() {
    }

    public EntityFactoryException(String message) {
        super(message);
    }

    public EntityFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityFactoryException(Throwable cause) {
        super(cause);
    }

    public EntityFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
