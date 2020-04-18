package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface EmployeeService {

    Optional<Employee> login(String user, char[] password) throws ServiceException;
    Optional<Employee> getEmployeeById(int Id) throws ServiceException;
    Optional<SystemRole> getSystemRoleByID(int ID) throws ServiceException;
    Optional<CrewRole> getCrewRoleByID(int ID) throws ServiceException;
    
    List<Employee> getAllEmployeeList() throws ServiceException;
    List<SystemRole> getAllSystemRoleList() throws ServiceException;
    List<CrewRole> getAllCrewRole() throws ServiceException;
    
	boolean addEmployee(Optional<Object> employee) throws ServiceException;
	boolean updatePassword(Optional<String> employeeId, Optional<char[]> password) throws ServiceException;
	boolean updateEmployeeInfo(Optional<Object> employeeOptional) throws ServiceException;
	boolean deleteEmployee(Optional<String> employeeId) throws ServiceException;
}
