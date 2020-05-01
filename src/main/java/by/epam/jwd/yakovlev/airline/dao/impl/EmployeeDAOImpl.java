package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.AbstractDAO;
import by.epam.jwd.yakovlev.airline.dao.EmployeeDAO;
import by.epam.jwd.yakovlev.airline.dao.SQLQuery;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.DAOFactoryEnum;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.*;

public class EmployeeDAOImpl extends AbstractDAO<Employee> implements EmployeeDAO {

	private static final Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public Optional<Employee> getEmployeeByID(int id) throws DaoException {

		String query = SQLQuery.GET_EMPLOYEE_BY_ID.getQuery();
		String[] queryParameters = { String.valueOf(id) };
		
		return getEntity(DAOFactoryEnum.EMPLOYEE, query, queryParameters);
	}

	@Override
	public List<Employee> getAllEmployeesList() throws DaoException {

		String query = SQLQuery.GET_ALL_EMPLOYEE.getQuery();
		String[] queryParameters = null;
		
		return getEntitiesList(DAOFactoryEnum.EMPLOYEE, query, queryParameters);
	}
	
	@Override
	public List<Employee> getCrewByFlightID(int flightID) throws DaoException {
		
		String query = SQLQuery.GET_CREW_BY_FLIGHT_ID.getQuery();
		String[] queryParameters = { String.valueOf(flightID) };
		
		return getEntitiesList(DAOFactoryEnum.EMPLOYEE, query, queryParameters);
	}
	
	@Override
	public boolean addEmployee(Optional<Employee> employeeOptional) throws DaoException {

		String query = SQLQuery.ADD_EMPLOYEE.getQuery();
		String[] queryParameters = new String[6];

		Employee employee = employeeOptional.orElseThrow(() -> new DaoException("Fail add due to null argument"));

		queryParameters[0] = employee.getFirstName();
		queryParameters[1] = employee.getLastName();
		queryParameters[2] = String.valueOf(employee.getSystemRole().getSystemRoleID());
		queryParameters[3] = employee.getNickname();
		queryParameters[4] = "0";
		queryParameters[5] = String.valueOf(employee.getCrewRole().getCrewRoleID());

		return update(query, queryParameters);
	}

	@Override
	public boolean deleteEmployee(Optional<Employee> employeeOptional) throws DaoException {

		Employee employee = employeeOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		
		int employeeId = employee.getId();
		String query = SQLQuery.DELETE_EMPLOYEE.getQuery();
		String[] queryParameters = { String.valueOf(employeeId) };
		
		return update(query, queryParameters);
	}
	
	@Override
	public Optional<Employee> getEmployeeByNicknameAndPassword(String nickname, String password) throws DaoException {

		if (StringUtils.isBlank(nickname)) {
			LOGGER.debug("Fail get employee because nickname is null");
			return Optional.empty();
		}

		String query = SQLQuery.GET_EMPLOYEE_BY_NICKNAME_AND_PASSWORD.getQuery();
		String[] queryParameters = { nickname, password };
		
		return getEntity(DAOFactoryEnum.EMPLOYEE, query, queryParameters);
	}
	
	@Override
	public boolean updatePassword(Optional<Employee> employeeOptional, Optional<String> passwordOptional)
			throws DaoException {
		
		Employee employee = employeeOptional
				.orElseThrow(() -> new DaoException("Fail add due to null argument"));
		
		int employeeID = employee.getId();
		String new_password = passwordOptional.orElse(StringConstant.EMPTY_STRING.getValue());

		String query = SQLQuery.UPDATE_EMPLOYEE_PASSWORD.getQuery();
		String[] queryParameters = {new_password, String.valueOf(employeeID)};
		
		return update(query, queryParameters);
	}

	@Override
	public boolean updateEmployee(Optional<Employee> employeeOptional) throws DaoException {
		
		if (!employeeOptional.isPresent()) {
			throw new DaoException("There is no employee to update");
		}
		
		Employee employee = employeeOptional.get();
		
		String employeeNickname = employee.getNickname();
		String employeeFirstName = employee.getFirstName();
		String employeeLastName = employee.getLastName();
		String employeeSystemRoleId = String.valueOf(employee.getSystemRole().getSystemRoleID());
		String employeeCrewRoleId = String.valueOf(employee.getCrewRole().getCrewRoleID());
		String employeeId = String.valueOf(employee.getId());
		
		String[] queryParameters = new String[6];
		
		String query = SQLQuery.UPDATE_EMPLOYEE.getQuery();
		
		queryParameters[0] = employeeNickname;
		queryParameters[1] = employeeFirstName;
		queryParameters[2] = employeeLastName;
		queryParameters[3] = employeeSystemRoleId;
		queryParameters[4] = employeeCrewRoleId;
		queryParameters[5] = employeeId;
		
		return update(query, queryParameters);
	}
}