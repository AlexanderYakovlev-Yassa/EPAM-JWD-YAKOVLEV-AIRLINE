package by.epam.jwd.yakovlev.airline.dao;

import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface CrewRoleDAO {

    List<CrewRole> getAllCrewRolesList() throws DaoException;
    Optional<CrewRole> getCrewRoleByID(int ID) throws DaoException;
    
    boolean addCrewRole(Optional<CrewRole> crewRoleOptional) throws DaoException;
    boolean deleteCrewRole(Optional<CrewRole> crewRoleOptional) throws DaoException;
    boolean updateCrewRole(Optional<CrewRole> crewRoleOptional) throws DaoException;
}
