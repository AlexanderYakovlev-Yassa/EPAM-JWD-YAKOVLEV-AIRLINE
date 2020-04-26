package by.epam.jwd.yakovlev.airline.service.impl;

import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.dao.CrewRoleDAO;
import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.CrewRoleService;
import by.epam.jwd.yakovlev.airline.validator.ValidatorFactory;

import java.util.*;

import org.apache.log4j.Logger;

public class CrewRoleServiceImpl implements CrewRoleService {

	private static final Logger LOGGER = Logger.getLogger(CrewRoleServiceImpl.class);
	private static final CrewRoleDAO CREW_ROLE_DAO = DAOFactory.getInstance().getCrewRoleDAO();
	private static final int DEFAULT_ID = 0;
	private static final String DEFAULT_NAME = "guest";

	@Override
	public List<CrewRole> getAllCrewRolesList() throws ServiceException {		
		
		try {
			return CREW_ROLE_DAO.getAllCrewRolesList();			
		} catch (DaoException e) {
			LOGGER.warn("Fail to get crew role", e);
			throw new ServiceException("Fail to get crew role", e);
		}
	}
	
	@Override
	public Optional<CrewRole> getCrewRoleByID(int id) throws ServiceException {
		
		if (id < 1) {
			return Optional.empty();
		}
		
		try {
			return CREW_ROLE_DAO.getCrewRoleByID(id);
		} catch (DaoException e) {
			LOGGER.debug("Fail get crew role because", e);
			throw new ServiceException("Fail get crew role", e);
		}
	}


	@Override
	public boolean addCrewRole(CrewRole crewRole) throws ServiceException {
		
		checkCrewRole(crewRole);
		
		try {
			return CREW_ROLE_DAO.addCrewRole(Optional.of(crewRole));
		} catch (DaoException e) {
			LOGGER.debug("Fail add crew role because", e);
			throw new ServiceException("Fail add crew role", e);
		}
	}

	@Override
	public boolean deleteCrewRole(CrewRole crewRole) throws ServiceException {
		
		checkCrewRole(crewRole);
		
		try {
			return CREW_ROLE_DAO.deleteCrewRole(Optional.of(crewRole));
		} catch (DaoException e) {
			LOGGER.debug("Fail delete crew role because", e);
			throw new ServiceException("Fail delete crew role", e);
		}
	}

	@Override
	public boolean updateCrewRole(CrewRole crewRole) throws ServiceException {
		
		checkCrewRole(crewRole);
		
		try {
			return CREW_ROLE_DAO.updateCrewRole(Optional.of(crewRole));
		} catch (DaoException e) {
			LOGGER.debug("Fail update crew role", e);
			throw new ServiceException("Fail update crew role", e);
		}
	}
	
	@Override
	public CrewRole getDefaultCrewRole() {
		
		CrewRole crewRole = new CrewRole();
		crewRole.setCrewRoleID(DEFAULT_ID);
		crewRole.setCrewRoleName(DEFAULT_NAME);
		
		return crewRole;
	}
	
	private void checkCrewRole(CrewRole crewRole) throws ServiceException {
		
		try {
			ValidatorFactory.getInstance().getCrewRoleValidator().check(crewRole);
		} catch (ValidatorException e) {
			LOGGER.debug("Fail validate the crew role", e);
			throw new ServiceException("Fail validate the crew role", e);
		}
	}
}
