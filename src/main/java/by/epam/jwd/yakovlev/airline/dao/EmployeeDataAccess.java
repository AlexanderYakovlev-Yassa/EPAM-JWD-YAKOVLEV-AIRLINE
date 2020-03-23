package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.DaoNoDataException;

public interface EmployeeDataAccess {

    Employee getEmployeeByNicName(String nic);
    String getEmployeePasswordByNicName(String nic) throws DaoException, DaoNoDataException;
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    boolean addEmployee(Employee employee);
}
