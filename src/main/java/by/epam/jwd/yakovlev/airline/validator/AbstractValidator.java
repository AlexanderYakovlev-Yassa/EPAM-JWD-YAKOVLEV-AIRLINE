package by.epam.jwd.yakovlev.airline.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.command.impl.UpdateEmployee;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;

public abstract class AbstractValidator {

	private static final String NAME = "^[A-ZА-ЯЁ][a-zа-яё]*$";
	private static final String WORD = "^[A-Z][a-z_-]*$";
	private static final String AIRCRAFT_SIDE_NUMBER = "^[A][\\d]{4}[A-Z]$";
	private static final int ZERO = 0;
	
	private static final Logger LOGGER = Logger.getLogger(AbstractValidator.class);
	
	protected void checkObjectIsNotNull(Object object) throws ValidatorException {
		
		if (object == null) {
			
			LOGGER.debug("checkObjectIsNotNull fail ");
			throw new ValidatorException("Object is null");
		}
	}
	
	protected void checkName(String name) throws ValidatorException {

		isPatternMatches(NAME, name);
	}

	protected void checkWord(String word) throws ValidatorException {

		isPatternMatches(WORD, word);
	}

	protected void checkAircraftSideNumber(String aircraftSideNumber) throws ValidatorException {

		isPatternMatches(AIRCRAFT_SIDE_NUMBER, aircraftSideNumber);
	}

	protected void checkNullOrEmptyString(String string) throws ValidatorException {

		if (StringUtils.isEmpty(string)) {
			LOGGER.debug("checkNullOrEmptyString fail ");
			throw new ValidatorException("Is null or empty");
		}
	}

	protected void checkNotNegativeInteger(int integer) throws ValidatorException {
		
		if (integer < ZERO) {
			LOGGER.debug("checkNotNegativeInteger fail " + integer);
			throw new ValidatorException("Is not positive");
		}
	}

	private void isPatternMatches(String patternString, String word) throws ValidatorException {

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(word);

		if (!matcher.matches()) {
			LOGGER.debug("isPatternMatches fail "+ patternString +" " + word);
			throw new ValidatorException("Does not match the pattern");
		}
	}
}
