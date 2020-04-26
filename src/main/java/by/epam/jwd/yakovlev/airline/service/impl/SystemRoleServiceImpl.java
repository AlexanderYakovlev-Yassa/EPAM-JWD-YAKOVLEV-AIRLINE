package by.epam.jwd.yakovlev.airline.service.impl;

import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.dao.SystemRoleDAO;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.SystemRoleService;
import by.epam.jwd.yakovlev.airline.validator.ValidatorFactory;

import java.util.*;

import org.apache.log4j.Logger;

public class SystemRoleServiceImpl implements SystemRoleService {

	private static final Logger LOGGER = Logger.getLogger(SystemRoleServiceImpl.class);
	private static final SystemRoleDAO SYSTEM_ROLE_DAO = DAOFactory.getInstance().getSystemRoleDAO();
	private static final int DEFAULT_ID = 0;
	private static final String DEFAULT_NAME = "guest";

	@Override
	public List<SystemRole> getAllSystemRolesList() throws ServiceException {

		try {
			return SYSTEM_ROLE_DAO.getAllSystemRolesList();
		} catch (DaoException e) {
			LOGGER.warn("Fail to get system role", e);
			throw new ServiceException("Fail to get employee", e);
		}
	}

	@Override
	public Optional<SystemRole> getSystemRoleByID(int id) throws ServiceException {

		if (id < 1) {
			return Optional.empty();
		}
		
		try {
			return SYSTEM_ROLE_DAO.getSystemRoleByID(id);
		} catch (DaoException e) {
			LOGGER.debug("Fail get system role", e);
			throw new ServiceException("Fail get system role", e);
		}
	}

	@Override
	public boolean addSystemRole(SystemRole systemRole) throws ServiceException {
		
		checkSystemRole(systemRole);

		try {
			return SYSTEM_ROLE_DAO.addSystemRole(Optional.of(systemRole));
		} catch (DaoException e) {
			LOGGER.debug("Fail add system role", e);
			throw new ServiceException("Fail add system role", e);
		}
	}

	@Override
	public boolean deleteSystemRole(SystemRole systemRole) throws ServiceException {
		
		checkSystemRole(systemRole);

		try {
			return SYSTEM_ROLE_DAO.deleteSystemRole(Optional.of(systemRole));
		} catch (DaoException e) {
			LOGGER.debug("Fail delete system role", e);
			throw new ServiceException("Fail delete system role", e);
		}
	}

	@Override
	public boolean updateSystemRole(SystemRole systemRole) throws ServiceException {
		
		checkSystemRole(systemRole);

		try {
			return SYSTEM_ROLE_DAO.updateSystemRole(Optional.of(systemRole));
		} catch (DaoException e) {
			LOGGER.debug("Fail update system role", e);
			throw new ServiceException("Fail update system role", e);
		}
	}

	@Override
	public SystemRole getDefaultSystemRole() {

		SystemRole systemRole = new SystemRole();
		systemRole.setSystemRoleID(DEFAULT_ID);
		systemRole.setSystemRoleName(DEFAULT_NAME);

		return systemRole;
	}

	private void checkSystemRole(SystemRole systemRole) throws ServiceException {

		try {
			ValidatorFactory.getInstance().getSystemRoleValidator().check(systemRole);
		} catch (ValidatorException e) {
			LOGGER.debug("Fail validate the system role", e);
			throw new ServiceException("Fail validate the system role", e);
		}
	}
}
