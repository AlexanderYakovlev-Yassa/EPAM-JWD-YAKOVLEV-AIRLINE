package by.epam.jwd.yakovlev.airline.factory.commandfactory;

import java.util.Map;

import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;

public abstract class AbstractCommandEntityFactory<T> {
	
	public abstract T create(Map<String, String[]> map) throws EntityFactoryException;

	protected int parseToPositiveIntOrElseZero(String string) throws EntityFactoryException {

		int result = 0;

		if (string == null) {
			return result;
		}

		try {
			result = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return result;
		}
		
		result = result < 0 ? 0 : result;
		
		return result;
	}
}
