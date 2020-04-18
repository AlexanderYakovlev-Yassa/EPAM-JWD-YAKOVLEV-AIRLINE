package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.exception.AirlineDataBaseConnectionException;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.pool.ConnectionsPool;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DAO {

    private static final Logger LOGGER = Logger.getLogger(DAO.class);
    private static final ConnectionsPool POOL = ConnectionsPool.INSTANCE;

    protected List<Object> getEntityListFromDB(DAOEntityFactory entityFactory, String query, String[] queryParameters) throws DaoException {

        List<Object> entityList = new ArrayList<>();

        if (entityFactory == null || query == null) {
            LOGGER.warn("Can't get data because do not have required parameters");
            throw new DaoException("Can't get data because do not have required parameters");
        }

        try (Connection connection = POOL.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(query);
            if (queryParameters != null) {
                addParametersToPreparedStatement(ps, queryParameters);
            }
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                entityFactory.make(rs).ifPresent(entityList::add);                
            }
        } catch (SQLException | AirlineDataBaseConnectionException e) {
            LOGGER.warn("Can't get data because " + e);
            throw new DaoException("Can't get data", e);
        }

        return entityList;
    }

    protected Optional<Object> getEntityFromDB(DAOEntityFactory entityFactory, String query, String[] queryParameters) throws DaoException {

        List<Object> objectsList = getEntityListFromDB(entityFactory, query, queryParameters);
        if (objectsList.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(objectsList.iterator().next());
    }

    protected boolean executeQuery(String query, String[] queryParameters) throws DaoException {
    	
    	boolean successFlag;
    	
    	LOGGER.debug("Query  - " + query); 
    	
    	for (String s : queryParameters) {
    		LOGGER.debug("Parameter  - " + s); 
    	}

        try (Connection connection = POOL.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(query);
            if (queryParameters != null) {
                addParametersToPreparedStatement(ps, queryParameters);
                LOGGER.debug("Operation complete"); 
            }
            int res = ps.executeUpdate();
            successFlag = (res > 0);
            LOGGER.debug("changed records " + res);
        } catch (SQLException | AirlineDataBaseConnectionException e) {
            LOGGER.warn("Fail add data because " + e);
            throw new DaoException("Fail add data", e);
        }
        
        return successFlag;
    }
    
	/*
	 * protected void executeCallable(String sql, Map<String, Object> parameters)
	 * throws DaoException {
	 * 
	 * try (Connection connection = POOL.getConnection()) { CallableStatement cl =
	 * connection.prepareCall(sql);
	 * 
	 * Set<Map.Entry<String, Object>> entrySet = parameters.entrySet();
	 * 
	 * for (Map.Entry<String, Object> e : entrySet) {
	 * 
	 * if (e.getValue().getClass() == String.class) { cl.setString(e.getKey(),
	 * (String) e.getValue()); } else if (e.getValue().getClass() == int.class) {
	 * cl.setInt(e.getKey(), (int) e.getValue()); } }
	 * 
	 * cl.execute();
	 * 
	 * } catch (SQLException | AirlineDataBaseConnectionException e) {
	 * LOGGER.warn("Fail add data because " + e); throw new
	 * DaoException("Fail add data", e); } }
	 */

    protected List<Integer> getIDList(String query, String parameterName) throws DaoException {

        List<Integer> integerList = new ArrayList<>();

        try (Connection connection = POOL.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.execute();
            ResultSet rs = ps.getResultSet();

            while (rs.next()) {
                Integer ID = rs.getInt(parameterName);
                integerList.add(ID);
            }
        } catch (SQLException | AirlineDataBaseConnectionException e) {
            LOGGER.warn("Can't get data because " + e);
            throw new DaoException("Can't get data", e);
        }

        return integerList;
    }

    private void addParametersToPreparedStatement(PreparedStatement ps, String[] queryParameters) throws SQLException {

        int parameterIndex;
        for (int i = 0; i < queryParameters.length; i++) {
            parameterIndex = i + 1;
            ps.setString(parameterIndex, queryParameters[i]);
        }
    }
}
