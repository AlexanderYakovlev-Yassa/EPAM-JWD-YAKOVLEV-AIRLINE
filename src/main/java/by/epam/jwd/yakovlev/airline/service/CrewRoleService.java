package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface CrewRoleService {

	/**
     * Returns the Optional of crew role
     * by crew role ID {@see CrewRole#crewRoleID}
     * 
     * @param crew roleID ID of the crew role
     * @return Optional of the crew role
     */
    Optional<CrewRole> getCrewRoleByID(int ID) throws ServiceException;
    
    /**
     * Returns the default crew role
     * 
     * @return the default crew role
     */
    CrewRole getDefaultCrewRole();
    
    /**
     * Returns the list of all the crew roles
     * 
     * @return list of all the crew roles
     */
    List<CrewRole> getAllCrewRolesList() throws ServiceException;
    
    /**
     * Adds a crew role to a storage
     * @param crew role {@see CrewRole}
     * @return <tt>true</tt> if adding was successful
     * @throws ServiceException if adding fail
     */
    boolean addCrewRole(CrewRole crewRole)  throws ServiceException;
    
    /**
     * Delete a crew role
     * @param crew role {@see CrewRole}
     * @return <tt>true</tt> if deleting was successful
     * @throws ServiceException if deleting fail
     */
    boolean deleteCrewRole(CrewRole crewRole)  throws ServiceException;
    
    /**
     * Update fields value of the aircraft.
     * Fields available for update:
     * the crew role name.
     * 
     * @param crew role {@see CrewRole}
     * @return <tt>true</tt> if updating was successful
     * @throws ServiceException if updating fail
     */
    boolean updateCrewRole(CrewRole crewRole)  throws ServiceException;
}
