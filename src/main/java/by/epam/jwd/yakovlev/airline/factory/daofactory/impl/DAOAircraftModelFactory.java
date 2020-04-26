package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOAircraftModelFactory extends AbstractDAOFactory<AircraftModel>{
	
	@Override
	public AircraftModel create(ResultSet resultSet) throws SQLException {
		
		AircraftModel aircraftModel = new AircraftModel();
		
		aircraftModel.setAircraftModelID(resultSet.getInt(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue()));
		aircraftModel.setAircraftModelName(resultSet.getString(StringConstant.AIRCRAFT_MODEL_NAME_KEY.getValue()));
		aircraftModel.setAircraftModelCapacity(resultSet.getInt(StringConstant.AIRCRAFT_MODEL_CAPACITY_KEY.getValue()));
		
		return aircraftModel;
	}
}
