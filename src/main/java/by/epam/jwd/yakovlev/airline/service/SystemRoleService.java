package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface SystemRoleService {

    Optional<SystemRole> getSystemRoleByID(int ID) throws ServiceException;
    SystemRole getDefaultSystemRole();
    
    List<SystemRole> getAllSystemRolesList() throws ServiceException;
    
    boolean addSystemRole(SystemRole systemRole)  throws ServiceException;
    boolean deleteSystemRole(SystemRole systemRole)  throws ServiceException;
    boolean updateSystemRole(SystemRole systemRole)  throws ServiceException;
}
