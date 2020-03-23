package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.dao.impl.EmployeeDataAccessImpl;

public enum DataAccessFactory {

    INSTANCE;

    private final EmployeeDataAccess employeeDataAccess = new EmployeeDataAccessImpl();

    public EmployeeDataAccess getEmployeeDataAccess() {
        return employeeDataAccess;
    }
}
