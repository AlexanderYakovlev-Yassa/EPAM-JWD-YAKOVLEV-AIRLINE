package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOEmployeeFactory extends AbstractDAOFactory<Employee> {

    @Override
    public Employee create(ResultSet resultSet) throws SQLException, DaoFactoryException {

        checkResultSetForNull(resultSet);
        resultSet.first();
        
        return createEmployee(resultSet);
    }
}
