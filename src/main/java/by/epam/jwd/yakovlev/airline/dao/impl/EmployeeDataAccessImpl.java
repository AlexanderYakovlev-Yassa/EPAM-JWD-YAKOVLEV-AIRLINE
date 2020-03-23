package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.EmployeeDataAccess;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.AirlineDataBaseConnectionException;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.DaoNoDataException;
import by.epam.jwd.yakovlev.airline.pool.ConnectionsPool;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDataAccessImpl implements EmployeeDataAccess {

    private static final ConnectionsPool pool = ConnectionsPool.INSTANCE;
    private static final Logger logger = LogManager.getLogger(EmployeeDataAccessImpl.class);
    private static final String GET_PASSWORD_BY_NIC_SQL =
            "SELECT system_password FROM employee WHERE system_nic_name = ?";

    @Override
    public Employee getEmployeeByNicName(String nic) {
        return null;
    }

    @Override
    public String getEmployeePasswordByNicName(String nic) throws DaoException, DaoNoDataException {

        String password = null;
        ResultSet rs;

        PreparedStatement ps = null;

        try {
            ps = getPreparedStatement(GET_PASSWORD_BY_NIC_SQL);
            ps.setString(1, nic);
            ps.execute();
            rs = ps.getResultSet();

            if (rs.next()) {
                password = rs.getString(1);
            } else {
                throw new DaoNoDataException("Such employee is not exists");
            }
        } catch (SQLException | AirlineDataBaseConnectionException e) {
            logger.warn("Can't get data because " + e.getMessage());
            throw new DaoException("Can't get data", e);
        }

        return password;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return false;
    }

    private PreparedStatement getPreparedStatement(String sql) throws AirlineDataBaseConnectionException, SQLException {

        PreparedStatement ps = null;
        Connection connection = null;

        connection = pool.getConnection();

        ps = connection.prepareStatement(sql);

        return ps;
    }

    private void closeConnection(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                logger.warn("Can't close connection because " + e.getMessage(), e);
            }
        }
    }
}
