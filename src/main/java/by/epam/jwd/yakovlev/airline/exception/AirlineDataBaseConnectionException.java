package by.epam.jwd.yakovlev.airline.exception;

public class AirlineDataBaseConnectionException extends Exception{

	private static final long serialVersionUID = 1L;

	public AirlineDataBaseConnectionException() {
    }

    public AirlineDataBaseConnectionException(String message) {
        super(message);
    }

    public AirlineDataBaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public AirlineDataBaseConnectionException(Throwable cause) {
        super(cause);
    }

    public AirlineDataBaseConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
