package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface CrewRoleService {

    Optional<CrewRole> getCrewRoleByID(int ID) throws ServiceException;
    CrewRole getDefaultCrewRole();
    
    List<CrewRole> getAllCrewRolesList() throws ServiceException;
    
    boolean addCrewRole(CrewRole crewRole)  throws ServiceException;
    boolean deleteCrewRole(CrewRole crewRole)  throws ServiceException;
    boolean updateCrewRole(CrewRole crewRole)  throws ServiceException;
}
