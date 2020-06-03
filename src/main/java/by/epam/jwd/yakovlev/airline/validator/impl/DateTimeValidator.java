package by.epam.jwd.yakovlev.airline.validator.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DateTimeValidator {
	
	private static final Logger LOGGER = Logger.getLogger(DateTimeValidator.class);
	private static final String MINIMAL_DATE = "1-01-2020 00:00";
	private static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat(StringConstant.DATE_TIME_SHORT_FORMAT.getValue());

	public void isDateValid(Date date) throws ValidatorException {
		
		if (date == null) {
			throw new ValidatorException("null date");
		}
		
		try {
			Date minimalDate = SHORT_DATE_FORMAT.parse(MINIMAL_DATE);
			if (minimalDate.after(date)) {
				throw new ValidatorException("Date can't be earlier than 01-01-2020");
			}
		} catch (ParseException e) {
			LOGGER.debug("Wrong initial date", e);
			throw new ValidatorException("Wrong initial date", e);
		}		
	}
	
	public void checkOrderOfDates(Date firstDate, Date secondDate) throws ValidatorException {
		
		if (firstDate == null || secondDate == null) {
			throw new ValidatorException("null date");
		}
		
		if (firstDate.after(secondDate)) {
			throw new ValidatorException("Wrong order of dates");
		}
	}
}
