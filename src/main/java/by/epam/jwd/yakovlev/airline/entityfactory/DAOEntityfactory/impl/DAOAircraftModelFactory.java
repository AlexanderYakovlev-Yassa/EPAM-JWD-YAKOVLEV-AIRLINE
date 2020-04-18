package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOAircraftModelFactory implements DAOEntityFactory{

	@Override
	public Optional<Object> make(ResultSet resultSet) throws SQLException {
		
		AircraftModel aircraftModel = new AircraftModel();
		
		aircraftModel.setAircraftModelID(resultSet.getInt(StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue()));
		aircraftModel.setAircraftModelName(resultSet.getString(StringConstant.AIRCRAFT_MODEL_NAME_KEY.getValue()));
		aircraftModel.setAircraftModelCapacity(resultSet.getInt(StringConstant.AIRCRAFT_MODEL_CAPACITY_KEY.getValue()));
		
		return Optional.of(aircraftModel);
	}

}
