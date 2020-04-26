package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface SystemRoleDAO {

    List<SystemRole> getAllSystemRolesList() throws DaoException;
    Optional<SystemRole> getSystemRoleByID(int ID) throws DaoException;
    
    boolean addSystemRole(Optional<SystemRole> systemRole) throws DaoException;
    boolean deleteSystemRole(Optional<SystemRole> systemRole) throws DaoException;
    boolean updateSystemRole(Optional<SystemRole> systemRole) throws DaoException;
}
