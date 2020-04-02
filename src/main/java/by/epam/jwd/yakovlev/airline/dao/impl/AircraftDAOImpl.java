package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.builder.AircraftModelBuilder;
import by.epam.jwd.yakovlev.airline.dao.AircraftDAO;
import by.epam.jwd.yakovlev.airline.dao.impl.util.DAOUtil;
import by.epam.jwd.yakovlev.airline.entity.Aircraft;
import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.AirlineDataBaseConnectionException;
import by.epam.jwd.yakovlev.airline.exception.BuilderException;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.pool.ConnectionsPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class AircraftDAOImpl implements AircraftDAO {

    private static final ConnectionsPool POOL = ConnectionsPool.INSTANCE;
    private static final Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class);
    private static final AircraftModelBuilder AIRCRAFT_MODEL_BUILDER = AircraftModelBuilder.INSTANCE;
    private static final DAOUtil DAO_UTIL = DAOUtil.INSTANCE;

    @Override
    public Set<AircraftModel> getAllAircraftModels() throws DaoException {

        Set<Properties> propertiesSet = DAO_UTIL.doSelectQuery(SQLQuery.GET_ALL_AIRCRAFT_MODELS.getQuery(), null);
        Set<AircraftModel> aircraftModelSet = new HashSet<>();

        for (Properties p : propertiesSet) {
            try {
                AircraftModel aircraftModel = AIRCRAFT_MODEL_BUILDER.build(p);
                aircraftModelSet.add(aircraftModel);
            } catch (BuilderException e) {
                throw new DaoException(e.getMessage(), e);
            }
        }

        return aircraftModelSet;
    }

    @Override
    public boolean addAircraft(Aircraft aircraft) {
        return false;
    }

    @Override
    public boolean addAircraftModel(AircraftModel aircraftModel) {

        if (aircraftModel == null) {
            return false;
        }

        boolean result = false;

        int aircraftModelID = aircraftModel.getAircraftModelID();
        String aircraftModelName = aircraftModel.getAircraftModelName();
        int aircraftModelCapacity = aircraftModel.getAircraftModelCapacity();

        Connection connection = null;
        try {
            connection = POOL.getConnection();
        } catch (AirlineDataBaseConnectionException e) {
            e.printStackTrace();
        }

        try (PreparedStatement ps = connection.prepareStatement(SQLQuery.ADD_AIRCRAFT_MODEL.getQuery())) {
            ps.setInt(1, aircraftModelID);
            ps.setString(2, aircraftModelName);
            ps.setInt(3, aircraftModelCapacity);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
