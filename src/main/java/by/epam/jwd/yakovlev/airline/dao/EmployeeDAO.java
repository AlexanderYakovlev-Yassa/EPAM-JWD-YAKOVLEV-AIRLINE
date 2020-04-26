package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.*;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    Optional<Employee> getEmployeeByNicknameAndPassword(String nickname, String password) throws DaoException;
    Optional<Employee> getEmployeeByID(int id) throws DaoException;
    
    List<Employee> getAllEmployeesList() throws DaoException;
    
    boolean addEmployee(Optional<Employee> employeeOptional) throws DaoException;
    boolean deleteEmployee(Optional<Employee> employeeOptional) throws DaoException;
    boolean updatePassword(Optional<Employee> employeeOptional, Optional<String> passwordOptional) throws DaoException;
    boolean updateEmployee(Optional<Employee> employeeOptional)  throws DaoException;
}
