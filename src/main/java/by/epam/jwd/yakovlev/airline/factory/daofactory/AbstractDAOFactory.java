package by.epam.jwd.yakovlev.airline.factory.daofactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entity.Airport;
import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.Flight;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public abstract class AbstractDAOFactory<T> {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractDAOFactory.class);
	private static final SimpleDateFormat DATE_FORMAT = 
			new SimpleDateFormat(StringConstant.DATE_TIME_LONG_FORMAT.getValue());

	public abstract T create(ResultSet resultSet) throws DaoFactoryException, SQLException;
	
	protected Airport createAirport(ResultSet resultSet) throws SQLException {
		
		Airport airport = new Airport();
		
		airport.setAirportID(resultSet.getInt(StringConstant.AIRPORT_ID_KEY.getValue()));
		airport.setAirportCity(resultSet.getString(StringConstant.AIRPORT_CITY_KEY.getValue()));
		
		return airport;
	}
	
	protected void checkResultSetForNull(ResultSet resultSet) throws DaoFactoryException {
		
		if (resultSet == null) {
			throw new DaoFactoryException("Result set is null");
		}
	}
	
	protected Aircraft createAircraft(ResultSet resultSet) throws SQLException {
		
		Aircraft aircraft = new Aircraft();
		
		aircraft.setAircraftID(resultSet.getInt(StringConstant.AIRCRAFT_ID_KEY.getValue()));
		aircraft.setAircraftSideNumber(resultSet.getString(StringConstant.AIRCRAFT_SIDE_NUMBER_KEY.getValue()));
		aircraft.setAircraftModel(createAircraftModel(resultSet));
		
		return aircraft;
	}
	
	protected AircraftModel createAircraftModel(ResultSet resultSet) throws SQLException {
		
		AircraftModel aircraftModel = new AircraftModel();
		
		aircraftModel.setAircraftModelID(resultSet.getInt(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue()));
		aircraftModel.setAircraftModelName(resultSet.getString(StringConstant.AIRCRAFT_MODEL_NAME_KEY.getValue()));
		aircraftModel.setAircraftModelCapacity(resultSet.getInt(StringConstant.AIRCRAFT_MODEL_CAPACITY_KEY.getValue()));
		
		return aircraftModel;
	}
	
	protected CrewRole createCrewRole(ResultSet resultSet) throws SQLException {
		
		CrewRole crewRole = new CrewRole();

        crewRole.setCrewRoleID(resultSet.getInt(StringConstant.CREW_ROLE_ID_KEY.getValue()));
        crewRole.setCrewRoleName(resultSet.getString(StringConstant.CREW_ROLE_NAME_KEY.getValue()));

        return crewRole;
	}
	
	protected Employee createEmployee(ResultSet resultSet) throws SQLException {

        Employee employee = new Employee();

        employee.setId(resultSet.getInt(StringConstant.EMPLOYEE_ID_KEY.getValue()));
        employee.setNickname(resultSet.getString(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue()));
        employee.setFirstName(resultSet.getString(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue()));
        employee.setLastName(resultSet.getString(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue()));
        employee.setSystemRole(createSystemRole(resultSet));
        employee.setCrewRole(createCrewRole(resultSet));
        
        return employee;
    }
	
	protected Flight createFlight(ResultSet resultSet) throws SQLException {

		Date departureTime = null;
		Date landingTime = null;		
		
		try {
			departureTime = DATE_FORMAT.parse(resultSet.getString(StringConstant.FLIGHT_DEPARTURE_TIME_KEY.getValue()));
			landingTime = DATE_FORMAT.parse(resultSet.getString(StringConstant.FLIGHT_LANDING_TIME_KEY.getValue()));			
		} catch (ParseException e) {
			LOGGER.debug("Wrong date time format", e);
		}
		
		Airport departureAirport = new Airport();
		departureAirport.setAirportID(resultSet.getInt(StringConstant.FLIGHT_DEPARTURE_AIRPORT_ID_KEY.getValue()));
		departureAirport.setAirportCity(resultSet.getString(StringConstant.FLIGHT_DEPARTURE_AIRPORT_CITY_KEY.getValue()));
		
		Airport destinationAirport = new Airport();
		destinationAirport.setAirportID(resultSet.getInt(StringConstant.FLIGHT_DESTINATION_AIRPORT_ID_KEY.getValue()));
		destinationAirport.setAirportCity(resultSet.getString(StringConstant.FLIGHT_DESTINATION_AIRPORT_CITY_KEY.getValue()));		
		
		Flight flight = new Flight();
		
		flight.setFlightID(resultSet.getInt(StringConstant.FLIGHT_ID_KEY.getValue()));
		flight.setDepartureTime(departureTime);
		flight.setLandingTime(landingTime);
		flight.setAircraft(createAircraft(resultSet));
		flight.setDepartureAirport(departureAirport);
		flight.setDestinationAirport(destinationAirport);
		
		return flight;
	}
	
	protected SystemRole createSystemRole(ResultSet resultSet) throws SQLException {
		
		SystemRole systemRole = new SystemRole();

        systemRole.setSystemRoleID(resultSet.getInt(StringConstant.SYSTEM_ROLE_ID_KEY.getValue()));
        systemRole.setSystemRoleName(resultSet.getString(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue()));

        return systemRole;
	}
}
