package by.epam.jwd.yakovlev.airline.dao.impl.util;

import by.epam.jwd.yakovlev.airline.dao.impl.EmployeeDAOImpl;
import by.epam.jwd.yakovlev.airline.exception.AirlineDataBaseConnectionException;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.pool.ConnectionsPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public enum DAOUtil {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class);
    private static final ConnectionsPool POOL = ConnectionsPool.INSTANCE;

    public Set<Properties> doSelectQuery(String query, String[] queryParameters) throws DaoException {

        Set propertiesSet = new HashSet<>();

        if (query == null) {
            return propertiesSet;
        }

        try (Connection connection = POOL.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(query);
            if (queryParameters != null) {
                int parameterIndex;
                for (int i = 0; i < queryParameters.length; i++) {
                    parameterIndex = i + 1;
                    ps.setString(parameterIndex, queryParameters[i]);
                }
            }
            ps.execute();

            ResultSet rs = ps.getResultSet();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {

                Properties temporaryProperties = new Properties();
                for (int i = 1; i <= columnCount; i++) {
                    if (rs.getString(i) != null) {
                        temporaryProperties.put(rsmd.getColumnName(i), rs.getString(i));
                    }
                }

                propertiesSet.add(temporaryProperties);
            }

        } catch (SQLException | AirlineDataBaseConnectionException e) {
            LOGGER.warn("Can't get data because " + e);
            throw new DaoException("Can't get data", e);
        }

        return propertiesSet;
    }
}
