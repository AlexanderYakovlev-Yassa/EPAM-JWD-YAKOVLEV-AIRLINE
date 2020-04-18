package by.epam.jwd.yakovlev.airline.validator.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.RegexPatterns;
import by.epam.jwd.yakovlev.airline.validator.Validator;

public class AircraftModelValidator implements Validator{
	
	private static final Logger LOGGER = Logger.getLogger(AircraftModelValidator.class);

	@Override
	public void check(Optional<Object> entityOptional) throws ValidatorException {
		
		if (!entityOptional.isPresent()) {
			LOGGER.debug("Null argument");
		}
		
		Object object = entityOptional.orElseThrow(() -> new ValidatorException("Null argument"));

		if (!(object instanceof AircraftModel)) {
			LOGGER.debug("Aircraft model failed validation. Wrong type.");
			throw new ValidatorException("Wrong argument type");
		}

		AircraftModel aircraftModel = (AircraftModel) object;
		
		if (aircraftModel.getAircraftModelName() == null 
				|| aircraftModel.getAircraftModelName().equals(StringUtils.EMPTY)) {
			LOGGER.debug("Aircraft model failed validation. Name can't be null or empty");
			throw new ValidatorException("Aircraft model failed validation. Name can't be null or empty");
		}
	}
}
