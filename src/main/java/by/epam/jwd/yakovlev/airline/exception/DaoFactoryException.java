package by.epam.jwd.yakovlev.airline.exception;

public class DaoFactoryException extends Exception{

	private static final long serialVersionUID = 1L;

	public DaoFactoryException() {
	}

	public DaoFactoryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoFactoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoFactoryException(String message) {
		super(message);
	}

	public DaoFactoryException(Throwable cause) {
		super(cause);
	}

}
