package by.epam.jwd.yakovlev.airline.factory.commandfactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

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
	
	public static Date parseStringToDate(String string) throws EntityFactoryException {
		
		SimpleDateFormat DATE_FORMAT = 
				new SimpleDateFormat(StringConstant.DATE_TIME_SHORT_FORMAT.getValue());
		
		try {
			return DATE_FORMAT.parse(string);
		} catch (ParseException e) {			
			throw new EntityFactoryException("Fail parse the date", e);
		}
	}
}
