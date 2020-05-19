package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

	/**
     * Returns the employee {@see Employee} by user name and password
     * 
     * @param user - user nickname which use for entering to the system
     * @param password - the char sequence of the user password
     * @return Optional of the employee
     * @throws ServiceException if such a combination of user nickname and password not exists
     */
    Optional<Employee> login(String user, char[] password) throws ServiceException;
    
    /**
     * Returns the employee {@see Employee} by ID
     * 
     * @param ID - the employee ID
     * @return Optional of the employee
     * @throws ServiceException if getting such an employee fail
     */
    Optional<Employee> getEmployeeById(int Id) throws ServiceException;
    
    /**
     * Returns the list of all the employees
     * 
     * @return list of all the employees
     */
    List<Employee> getAllEmployeesList() throws ServiceException;
    
    /**
     * Adds an employee to a storage
     * @param employee {@see Employee}
     * @return <tt>true</tt> if adding was successful
     * @throws ServiceException if adding fail
     */
	boolean addEmployee(Employee employee) throws ServiceException;
	
	/**
     * Update the employee password.
     * 
     * @param employee {@see Employee}
     * @param password - the char sequence of the user password
     * @return <tt>true</tt> if updating was successful
     * @throws ServiceException if updating fail
     */
	boolean updatePassword(Employee employee, char[] password) throws ServiceException;
	
	/**
     * Update fields value of the employee.
     * Fields available for update:
     * the employee nickname,
     * the employee first name,
     * the employee last name,
     * the employee system role ID,
     * the employee crew role ID. 
     * 
     * @param employee {@see Employee}
     * @return <tt>true</tt> if updating was successful
     * @throws ServiceException if updating fail
     */
	boolean updateEmployee(Employee employee) throws ServiceException;
	
	/**
     * Delete an employee
     * @param employee {@see Employee}
     * @return <tt>true</tt> if deleting was successful
     * @throws ServiceException if deleting fail
     */
	boolean deleteEmployee(Employee employee) throws ServiceException;
}
