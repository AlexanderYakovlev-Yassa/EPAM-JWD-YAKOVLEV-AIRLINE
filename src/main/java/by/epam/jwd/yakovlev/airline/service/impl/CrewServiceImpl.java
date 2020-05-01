package by.epam.jwd.yakovlev.airline.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.dao.CrewDAO;
import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.dao.EmployeeDAO;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.service.CrewService;

public class CrewServiceImpl implements CrewService{
	
	private static final Logger LOGGER = Logger.getLogger(CrewServiceImpl.class);
	private static final CrewDAO CREW_DAO = DAOFactory.getInstance().getCrewDAO();
	private static final EmployeeDAO EMPLOYEE_DAO = DAOFactory.getInstance().getEmployeeDAO();

	@Override
	public boolean addCrewMember(int flightID, int employeeID) throws ServiceException {
		
		if (flightID < 1 || employeeID < 1) {
			return false;
		}		
		
		try {
			List<Employee> crew = EMPLOYEE_DAO.getCrewByFlightID(flightID);
			
			for (Employee e : crew) {
				
				if (e.getId() == employeeID) {
					return false;
				}
			}
			
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
