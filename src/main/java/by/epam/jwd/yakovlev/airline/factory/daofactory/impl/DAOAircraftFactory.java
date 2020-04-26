package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOAircraftFactory extends AbstractDAOFactory<Aircraft>{
	
	@Override
	public Aircraft create(ResultSet resultSet) throws SQLException {
		
		Aircraft aircraft = new Aircraft();
		
		aircraft.setAircraftID(resultSet.getInt(StringConstant.AIRCRAFT_ID_KEY.getValue()));
		aircraft.setAircraftSideNumber(resultSet.getString(StringConstant.AIRCRAFT_SIDE_NUMBER_KEY.getValue()));
		
		AircraftModel aircraftModel = new AircraftModel();
		
		aircraftModel.setAircraftModelID(resultSet.getInt(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue()));
		aircraftModel.setAircraftModelName(resultSet.getString(StringConstant.AIRCRAFT_MODEL_NAME_KEY.getValue()));
		aircraftModel.setAircraftModelCapacity(resultSet.getInt(StringConstant.AIRCRAFT_MODEL_CAPACITY_KEY.getValue()));
		
		aircraft.setAircraftModel(aircraftModel);
		
		return aircraft;
	}	
}
