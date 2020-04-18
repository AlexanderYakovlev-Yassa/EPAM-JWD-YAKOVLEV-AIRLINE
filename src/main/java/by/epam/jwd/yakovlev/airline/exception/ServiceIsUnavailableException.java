package by.epam.jwd.yakovlev.airline.exception;

public class ServiceIsUnavailableException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceIsUnavailableException() {
    }

    public ServiceIsUnavailableException(String message) {
        super(message);
    }

    public ServiceIsUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceIsUnavailableException(Throwable cause) {
        super(cause);
    }

    public ServiceIsUnavailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
