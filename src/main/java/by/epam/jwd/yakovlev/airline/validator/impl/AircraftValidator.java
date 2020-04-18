package by.epam.jwd.yakovlev.airline.validator.impl;

import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.RegexPatterns;
import by.epam.jwd.yakovlev.airline.validator.Validator;

public class AircraftValidator implements Validator{
	
	private static final Logger LOGGER = Logger.getLogger(AircraftValidator.class);

	@Override
	public void check(Optional<Object> entityOptional) throws ValidatorException {
		
		if (!entityOptional.isPresent()) {
			LOGGER.debug("Null argument");
		}
		
		Object object = entityOptional.orElseThrow(() -> new ValidatorException("Null argument"));

		if (!(object instanceof Aircraft)) {
			LOGGER.debug("Aircraft failed validation. Wrong type.");
			throw new ValidatorException("Wrong type argument");
		}

		Aircraft aircraft = (Aircraft) object;
		
		if (aircraft.getAircraftModel() == null) {
			LOGGER.debug("Aircraft failed validation. Aircraft model can't be null or empty");
			throw new ValidatorException("Aircraft failed validation. Aircraft model can't be null or empty");
		}
		
		if (aircraft.getAircraftSideNumber() == null 
				|| isPatternMatches(RegexPatterns.AIRCRAFT_SIDE_NUMBER.getPattern(), aircraft.getAircraftSideNumber())) {
			LOGGER.debug("Aircraft model failed validation. Name can't be null or empty");
			throw new ValidatorException("Aircraft failed validation. Name can't be null or empty");
		}		
	}
}
