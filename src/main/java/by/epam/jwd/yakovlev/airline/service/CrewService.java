package by.epam.jwd.yakovlev.airline.service;

import by.epam.jwd.yakovlev.airline.entity.Crew;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;

public interface CrewService {
	
	boolean addCrewMember(int flightID, int employeeID) throws ServiceException;
	boolean deleteCrewMember(int flightID, int employeeID) throws ServiceException;
	
	Crew getCrewByFlightID(int flightID) throws ServiceException;
}
