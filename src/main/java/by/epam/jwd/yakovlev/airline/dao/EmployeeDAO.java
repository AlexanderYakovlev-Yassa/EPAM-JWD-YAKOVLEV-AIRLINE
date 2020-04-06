package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.*;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface EmployeeDAO {

    Optional<Employee> getEmployeeByNickname(String nickname) throws DaoException;
    Optional<Employee> getEmployeeByID(int ID) throws DaoException;
    Optional<String> getEmployeePasswordByNicName(String nic) throws DaoException;
    List<Integer> getAllEmployeeIDList() throws DaoException;
    List<Integer> getAllSystemRoleIDList() throws DaoException;
    List<Integer> getAllCrewRoleIDList() throws DaoException;
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    void addEmployee(Map<String, String> employee) throws DaoException;

    Optional<SystemRole> getSystemRoleByID(int ID) throws DaoException;
    Optional<CrewRole> getCrewRoleByID(int ID) throws DaoException;
}
