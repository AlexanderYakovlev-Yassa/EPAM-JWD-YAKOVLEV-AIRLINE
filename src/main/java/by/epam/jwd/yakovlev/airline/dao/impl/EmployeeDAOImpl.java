package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.dao.EmployeeDAO;
import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityFactory;
import by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory.DAOEntityType;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;
import org.apache.taglibs.standard.tag.common.core.Util;

import java.util.*;
import java.util.function.Supplier;

public class EmployeeDAOImpl extends DAO implements EmployeeDAO {

	private static final Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public Optional<Employee> getEmployeeByID(int ID) throws DaoException {

		DAOEntityFactory employeeFactory = DAOEntityType.EMPLOYEE.getEntityFactory();
		String query = SQLQuery.GET_EMPLOYEE_BY_ID.getQuery();
		String[] parameter = { String.valueOf(ID) };
		Optional<Object> optionalObject = getEntityFromDB(employeeFactory, query, parameter);

		Optional<Employee> optionalEmployee = optionalObject.map(Employee.class::cast);
		
		return optionalEmployee;
	}

	@Override
	public List<Integer> getAllEmployeeIDList() throws DaoException {

		return getIDList(SQLQuery.GET_ALL_EMPLOYEE_ID.getQuery(), StringConstant.EMPLOYEE_ID_KEY.getValue());
	}

	@Override
	public List<Integer> getAllSystemRoleIDList() throws DaoException {

		return getIDList(SQLQuery.GET_ALL_SYSTEM_ROLE_ID.getQuery(), StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
	}

	@Override
	public List<Integer> getAllCrewRoleIDList() throws DaoException {

		return getIDList(SQLQuery.GET_ALL_CREW_ROLE_ID.getQuery(), StringConstant.CREW_ROLE_ID_KEY.getValue());
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

		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean deleteEmployee(Optional<String> employeeIdOptional) throws DaoException {

		String employeeId = employeeIdOptional.orElse(StringConstant.ZERO.getValue());
		String query = SQLQuery.DELETE_EMPLOYEE.getQuery();
		String[] queryParameters = { employeeId };
		
		return executeQuery(query, queryParameters);
	}

	@Override
	public Optional<SystemRole> getSystemRoleByID(int ID) throws DaoException {

		String query = SQLQuery.GET_SYSTEM_ROLE_BY_ID.getQuery();
		String[] queryParameter = { String.valueOf(ID) };
		DAOEntityFactory entityFactory = DAOEntityType.SYSTEM_ROLE.getEntityFactory();

		Optional<Object> objectOptional = getEntityFromDB(entityFactory, query, queryParameter);

		Optional<SystemRole> systemRoleOptional = objectOptional.map(SystemRole.class::cast);

		return systemRoleOptional;
	}

	@Override
	public Optional<CrewRole> getCrewRoleByID(int ID) throws DaoException {

		String query = SQLQuery.GET_CREW_ROLE_BY_ID.getQuery();
		String[] queryParameter = { String.valueOf(ID) };
		DAOEntityFactory entityFactory = DAOEntityType.CREW_ROLE.getEntityFactory();

		Optional<Object> objectOptional = getEntityFromDB(entityFactory, query, queryParameter);

		Optional<CrewRole> crewRoleOptional = objectOptional.map(CrewRole.class::cast);

		return crewRoleOptional;
	}

	@Override
	public Optional<Employee> getEmployeeByNicknameAndPassword(String nickname, String password) throws DaoException {

		if (nickname == null) {
			LOGGER.debug("Fail get employee because nickname is null");
			return Optional.empty();
		}

		DAOEntityFactory employeeFactory = DAOEntityType.EMPLOYEE.getEntityFactory();
		String query = SQLQuery.GET_EMPLOYEE_BY_NICKNAME_AND_PASSWORD.getQuery();
		String[] parameter = { nickname, password };
		List<Object> employeeLis = getEntityListFromDB(employeeFactory, query, parameter);

		if (employeeLis.size() < 1) {
			LOGGER.debug("no such record");
			return Optional.empty();
		}

		return Optional.of((Employee)employeeLis.iterator().next());
	}
	
	@Override
	public boolean updatePassword(Optional<String> employeeIdOptional, Optional<String> passwordOptional)
			throws DaoException {
		
		String employeeId = employeeIdOptional.orElse(StringConstant.ZERO.getValue());
		String new_password = passwordOptional.orElse(StringConstant.EMPTY_STRING.getValue());

		String query = SQLQuery.UPDATE_EMPLOYEE_PASSWORD.getQuery();
		String[] queryParameters = {new_password, employeeId};
		
		return executeQuery(query, queryParameters);
	}

	@Override
	public boolean updateEmployeeInfo(Optional<Employee> employeeOptional) throws DaoException {
		
		if (!employeeOptional.isPresent()) {
			throw new DaoException("There is no employee to update");
		}
		
		Employee employee = employeeOptional.get();
		
		String employeeNickname = employee.getNickname();
		String employeeFirstName = employee.getFirstName();
		String employeeLastName = employee.getLastName();
		String employeeSystemRoleId = String.valueOf(employee.getSystemRole().getSystemRoleID());
		String employeeCrewRoleId = String.valueOf(employee.getSystemRole().getSystemRoleID());
		String employeeId = String.valueOf(employee.getId());
		
		String[] queryParameters = new String[6];
		
		String query = SQLQuery.UPDATE_EMPLOYEE_INFO.getQuery();
		
		queryParameters[0] = employeeNickname;
		queryParameters[1] = employeeFirstName;
		queryParameters[2] = employeeLastName;
		queryParameters[3] = employeeSystemRoleId;
		queryParameters[4] = employeeCrewRoleId;
		queryParameters[5] = employeeId;
		
		return executeQuery(query, queryParameters);
	}
}