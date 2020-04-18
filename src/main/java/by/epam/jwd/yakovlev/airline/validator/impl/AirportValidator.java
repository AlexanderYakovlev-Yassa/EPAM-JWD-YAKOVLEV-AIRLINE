package by.epam.jwd.yakovlev.airline.validator.impl;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.Validator;

public class AirportValidator implements Validator {
	
	private static final Logger LOGGER = Logger.getLogger(AirportValidator.class);

	@Override
	public void check(Optional<Object> entityOptional) throws ValidatorException {
		
		if (!entityOptional.isPresent()) {
			LOGGER.debug("Null argument");
		}
		
		Object object = entityOptional.orElseThrow(() -> new ValidatorException("Null argument"));

		if (!(object instanceof Airport)) {
			LOGGER.debug("Airport failed validation. Wrong type.");
			throw new ValidatorException("Wrong argument type");
		}

		Airport airport = (Airport) object;
		
		if (airport.getAirportCity() == null 
				|| airport.getAirportCity().equals(StringUtils.EMPTY)) {
			LOGGER.debug("Airport failed validation. City can't be null or empty");
			throw new ValidatorException("Airport failed validation. City can't be null or empty");
		}
	}
}
