package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> login(String user, char[] password) throws ServiceException;
    Optional<Employee> getEmployeeById(int Id) throws ServiceException;
    
    List<Employee> getAllEmployeesList() throws ServiceException;
    
	boolean addEmployee(Employee employee) throws ServiceException;
	boolean updatePassword(Employee employee, char[] password) throws ServiceException;
	boolean updateEmployee(Employee employee) throws ServiceException;
	boolean deleteEmployee(Employee employee) throws ServiceException;
}
