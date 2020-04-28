package by.epam.jwd.yakovlev.airline.service.impl;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.CrewDAO;
import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.CrewService;

public class CrewServiceImpl implements CrewService{
	
	private static final Logger LOGGER = Logger.getLogger(CrewServiceImpl.class);
	private static final CrewDAO CREW_DAO = DAOFactory.getInstance().getCrewDAO();

	@Override
	public boolean addCrewMember(int flightID, int employeeID) throws ServiceException {
		
		if (flightID < 1 || employeeID < 1) {
			return false;
		}
		
		try {
			return CREW_DAO.addCrewMember(flightID, employeeID);
		} catch (DaoException e) {
			LOGGER.debug("Fail add the crew member", e);
			throw new ServiceException("Fail add the crew member", e);
		}
	}

	@Override
	public boolean deleteCrewMember(int flightID, int employeeID) throws ServiceException {
		
		if (flightID < 1 || employeeID < 1) {
			return false;
		}
		
		try {
			return CREW_DAO.deleteCrewMember(flightID, employeeID);
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the crew member", e);
			throw new ServiceException("Fail delete the crew member", e);
		}
	}
}
