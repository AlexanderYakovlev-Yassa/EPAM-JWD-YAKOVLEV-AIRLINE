package by.epam.jwd.yakovlev.airline.validator.impl;

import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.Validator;

public class FlightValidator implements Validator{
	
	private static final Logger LOGGER = Logger.getLogger(FlightValidator.class);

	@Override
	public void check(Optional<Object> entityOptional) throws ValidatorException {
		
		if (!entityOptional.isPresent()) {
			LOGGER.debug("Null argument");
		}
		
		Object object = entityOptional.orElseThrow(() -> new ValidatorException("Null argument"));

		if (!(object instanceof Flight)) {
			LOGGER.debug("Flight failed validation. Wrong type.");
			throw new ValidatorException("Wrong argument type");
		}

		Flight flight = (Flight) object;
		
		if (flight.getAircraft() == null) {
			LOGGER.debug("Flight failed validation. Aircraft can't be null");
			throw new ValidatorException("Flight failed validation. Aircraft can't be null");
		}
		
		if (flight.getDepartureAirport() == null) {
			LOGGER.debug("Flight failed validation. Departure airport can't be null");
			throw new ValidatorException("Flight failed validation. Departure airport can't be null");
		}
		
		if (flight.getDestinationAirport() == null) {
			LOGGER.debug("Flight failed validation. Destination airport can't be null");
			throw new ValidatorException("Flight failed validation. Destination airport can't be null");
		}
		
		if (flight.getDepartureTime() == null || flight.getLandingTime() == null) {
			LOGGER.debug("Flight failed validation. Time can't be null");
			throw new ValidatorException("Flight failed validation. Time can't be null");
		}
		
		if (flight.getLandingTime().before(flight.getDepartureTime())) {
			LOGGER.debug("Flight failed validation. Landing time must be after departure.");
			throw new ValidatorException("Flight failed validation. Landing time must be after departure.");
		}
	}
}
