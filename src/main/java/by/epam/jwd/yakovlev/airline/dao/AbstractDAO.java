package by.epam.jwd.yakovlev.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.exception.AirlineDataBaseConnectionException;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;
import by.epam.jwd.yakovlev.airline.pool.ConnectionsPool;

public abstract class AbstractDAO<T> {

	private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
	private static final ConnectionsPool POOL = ConnectionsPool.INSTANCE;
	
	@SuppressWarnings("unchecked")
	protected T getEntity(DAOFactoryEnum factory, String query, String[] queryParameters)
			throws DaoException {

		PreparedStatement preparedStatement = getPreparedStatement(query);
		AbstractDAOFactory<?> concreatFactory = factory.getConcreatFactory();
		T entity = null;
		
		try {
			if (queryParameters != null) {
				for (int i = 1; i <= queryParameters.length; i++) {
					preparedStatement.setString(i, queryParameters[i - 1]);
				}
			}
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();
			
			entity = (T) concreatFactory.create(resultSet);			
		} catch (SQLException | DaoFactoryException e) {
			throw new DaoException("Fail get data", e);
		} finally {
			closeStatement(preparedStatement);
		}

		return entity;
	}

	protected boolean update(String query, String[] queryParameters) throws DaoException {

		PreparedStatement preparedStatement = getPreparedStatement(query);

		try {
			for (int i = 1; i <= queryParameters.length; i++) {
				preparedStatement.setString(i, queryParameters[i - 1]);
			}

			return preparedStatement.executeUpdate() > 0;

		} catch (SQLException e) {
			throw new DaoException("Fail get data", e);
		} finally {
			closeStatement(preparedStatement);
		}
	}

	private PreparedStatement getPreparedStatement(String query) throws DaoException {

		PreparedStatement preparedStatement = null;

		try (Connection connection = POOL.getConnection()) {
			preparedStatement = connection.prepareStatement(query);
		} catch (SQLException | AirlineDataBaseConnectionException e) {
			throw new DaoException("Fail get data", e);
		}
		return preparedStatement;
	}

	private void closeStatement(PreparedStatement preparedStatement) {

		if (preparedStatement != null) {

			try {
				preparedStatement.close();
			} catch (SQLException e) {
				LOGGER.debug("Fail close prepared statement", e);				
			}
		}
	}
}
