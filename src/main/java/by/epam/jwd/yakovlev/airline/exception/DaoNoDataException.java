package by.epam.jwd.yakovlev.airline.exception;

public class DaoNoDataException extends Exception{

	private static final long serialVersionUID = 1L;

	public DaoNoDataException() {
    }

    public DaoNoDataException(String message) {
        super(message);
    }

    public DaoNoDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoNoDataException(Throwable cause) {
        super(cause);
    }

    public DaoNoDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
