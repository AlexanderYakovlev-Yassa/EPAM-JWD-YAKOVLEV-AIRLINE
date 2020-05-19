package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface SystemRoleService {

	/**
     * Returns the Optional of system role
     * by system role ID {@see SystemRole#systemRoleID}
     * 
     * @param system roleID ID of the system role
     * @return Optional of the system role
     */
    Optional<SystemRole> getSystemRoleByID(int ID) throws ServiceException;
    
    /**
     * Returns the default system role
     * 
     * @return the default system role
     */
    SystemRole getDefaultSystemRole();
    
    /**
     * Returns the list of all the system roles
     * 
     * @return list of all the system roles
     */
    List<SystemRole> getAllSystemRolesList() throws ServiceException;
    
    /**
     * Adds an system role to a storage
     * @param system role {@see SystemRole}
     * @return <tt>true</tt> if adding was successful
     * @throws ServiceException if adding fail
     */
    boolean addSystemRole(SystemRole systemRole)  throws ServiceException;
    
    /**
     * Delete an system role
     * @param system role {@see SystemRole}
     * @return <tt>true</tt> if deleting was successful
     * @throws ServiceException if deleting fail
     */
    boolean deleteSystemRole(SystemRole systemRole)  throws ServiceException;
    
    /**
     * Update fields value of the aircraft.
     * Fields available for update:
     * the system role name.
     * 
     * @param system role {@see SystemRole}
     * @return <tt>true</tt> if updating was successful
     * @throws ServiceException if updating fail
     */
    boolean updateSystemRole(SystemRole systemRole)  throws ServiceException;
}
