package by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory;

import java.util.Map;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;

public interface CommandEntityFactory {

	Optional<Object> create(Map<String, String[]> map) throws EntityFactoryException;

	default int parseToIntID(String string) throws EntityFactoryException {

		int result = 0;

		if (string == null) {
			return result;
		}

		try {
			result = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return result;
		}
		
		return result;
	}
}
