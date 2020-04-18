package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

//import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityType;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOAircraftFactory implements DAOEntityFactory{
	
	//private static final Logger LOGGER = Logger.getLogger(DAOAircraftFactory.class);
	
	@Override
	public Optional<Object> make(ResultSet resultSet) throws SQLException {
		
		Aircraft aircraft = new Aircraft();
		
		aircraft.setAircraftID(resultSet.getInt(StringConstant.AIRCRAFT_ID_KEY.getValue()));
		aircraft.setAircraftSideNumber(resultSet.getString(StringConstant.AIRCRAFT_SIDE_NUMBER_KEY.getValue()));
		
		DAOEntityFactory aircraftModelFactory = DAOEntityType.AIRCRAFT_MODEL.getEntityFactory();
		
		Optional<AircraftModel> aircraftModelOptional = aircraftModelFactory.make(resultSet).map(AircraftModel.class::cast);		 
		aircraftModelOptional.ifPresent(aircraft::setAircraftModel);		
		
		return Optional.of(aircraft);
	}	
}
