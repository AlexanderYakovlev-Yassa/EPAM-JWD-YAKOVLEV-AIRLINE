package by.epam.jwd.yakovlev.airline.validator.impl;

import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.validator.AbstractValidator;

public class FlightValidator extends AbstractValidator{
	
	
	public void check(Flight flight) throws ValidatorException {						
		
		checkObjectIsNotNull(flight);
		checkNotNegativeInteger(flight.getFlightID());
		checkObjectIsNotNull(flight.getAircraft());
		checkObjectIsNotNull(flight.getDepartureAirport());
		checkObjectIsNotNull(flight.getDestinationAirport());
		checkObjectIsNotNull(flight.getDepartureTime());
		checkObjectIsNotNull(flight.getLandingTime());
		
		if (flight.getDepartureAirport().getAirportID() == flight.getDestinationAirport().getAirportID()) {			
			throw new ValidatorException("Departure and destination are same airport");
		}
				
		if (flight.getDepartureTime().after(flight.getLandingTime())) {
			throw new ValidatorException("Landing is after departure");
		}
	}
}
