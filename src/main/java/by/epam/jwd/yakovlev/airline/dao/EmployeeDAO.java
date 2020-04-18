package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.*;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface EmployeeDAO {

    Optional<Employee> getEmployeeByNicknameAndPassword(String nickname, String password) throws DaoException;
    Optional<Employee> getEmployeeByID(int ID) throws DaoException;
    List<Integer> getAllEmployeeIDList() throws DaoException;
    List<Integer> getAllSystemRoleIDList() throws DaoException;
    List<Integer> getAllCrewRoleIDList() throws DaoException;
    boolean addEmployee(Optional<Employee> employee) throws DaoException;
    boolean deleteEmployee(Optional<String> id) throws DaoException;
    boolean updatePassword(Optional<String> nicknameOptional, Optional<String> passwordOptional) throws DaoException;
    boolean updateEmployeeInfo(Optional<Employee> employeeOptional)  throws DaoException;

    Optional<SystemRole> getSystemRoleByID(int ID) throws DaoException;
    Optional<CrewRole> getCrewRoleByID(int ID) throws DaoException;
}
