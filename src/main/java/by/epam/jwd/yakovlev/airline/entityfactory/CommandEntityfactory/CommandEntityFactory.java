package by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory;

import java.util.Map;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;

public interface CommandEntityFactory {

	Optional<Object> create(Map<String, String[]> map) throws EntityFactoryException;

	default int parseToPositiveIntOrElseZero(String string) throws EntityFactoryException {

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
