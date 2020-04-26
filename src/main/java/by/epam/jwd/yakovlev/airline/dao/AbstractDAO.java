package by.epam.jwd.yakovlev.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.exception.AirlineDataBaseConnectionException;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;
import by.epam.jwd.yakovlev.airline.pool.ConnectionsPool;

public abstract class AbstractDAO<T> {

	private static final Logger LOGGER = Logger.getLogger(AbstractDAO.class);
	private static final ConnectionsPool POOL = ConnectionsPool.INSTANCE;

	protected Optional<T> getEntity(DAOFactoryEnum factory, String query, String[] queryParameters) throws DaoException {
		
		List<T> entitiesList = getEntitiesList(factory, query, queryParameters);
		Optional<T> tOptional = Optional.empty();
		
		if (entitiesList.isEmpty()) {
			return tOptional;
		}

		return Optional.of(entitiesList.iterator().next());
	}

	@SuppressWarnings("unchecked")
	protected List<T> getEntitiesList(DAOFactoryEnum factory, String query, String[] queryParameters)
			throws DaoException {

		PreparedStatement preparedStatement = getPreparedStatement(query);
		AbstractDAOFactory<?> concreatFactory = factory.getConcreatFactory();
		List<T> entitiesList = new ArrayList<>();

		try {
			if (queryParameters != null) {
				for (int i = 1; i <= queryParameters.length; i++) {
					preparedStatement.setString(i, queryParameters[i - 1]);
				}
			}
			preparedStatement.execute();
			ResultSet resultSet = preparedStatement.getResultSet();

			while (resultSet.next()) {
				entitiesList.add((T) concreatFactory.create(resultSet));
			}
		} catch (SQLException e) {
			throw new DaoException("Fail get data", e);
		} finally {
			closeStatement(preparedStatement);
		}

		return entitiesList;
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
