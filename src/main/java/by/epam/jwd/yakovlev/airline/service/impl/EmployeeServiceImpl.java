package by.epam.jwd.yakovlev.airline.service.impl;

import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.dao.EmployeeDAO;
import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.entityfactory.CommandEntityfactory.EntityFactoryTypesEnum;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.util.HashGenerator;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import by.epam.jwd.yakovlev.airline.validator.ValidatorsEnum;

import java.util.*;

import org.apache.log4j.Logger;

public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);
	private static final HashGenerator HASH_GENERATOR = new HashGenerator();
	private static final EmployeeDAO EMPLOYEE_DAO = DAOFactory.INSTANCE.getEmployeeDAO();
	private static final int DEFAULT_ID = 0;
	private static final String DEFAULT_NAME = "guest";

	@Override
	public Optional<Employee> login(String user, char[] password) throws ServiceException {

		Optional<Employee> optionalEmployee = getDefaultUser();

		if (user == null || password == null) {
			return optionalEmployee;
		}

		String passwordHash = HASH_GENERATOR.getMD5Hash(password);

		try {
			optionalEmployee = EMPLOYEE_DAO.getEmployeeByNicknameAndPassword(user, passwordHash);
		} catch (DaoException e) {
			LOGGER.warn("Can't get an employee because " + e.getMessage());
			throw new ServiceException("Service failed", e);
		}

		optionalEmployee = optionalEmployee.isPresent() ? optionalEmployee : getDefaultUser();

		return optionalEmployee;
	}

	@Override
	public List<Employee> getAllEmployeeList() throws ServiceException {

		List<Integer> allEmployeeIDList;
		List<Employee> allEmployeeList = new ArrayList<>();
		try {
			allEmployeeIDList = EMPLOYEE_DAO.getAllEmployeeIDList();
			for (Integer id : allEmployeeIDList) {
				EMPLOYEE_DAO.getEmployeeByID(id).ifPresent(allEmployeeList::add);
			}
		} catch (DaoException e) {
			LOGGER.warn("Fail to get employee because " + e.getMessage());
			throw new ServiceException("Fail to get employee.", e);
		}

		return allEmployeeList;
	}

	@Override
	public List<SystemRole> getAllSystemRoleList() throws ServiceException {

		List<Integer> allSystemRoleIDList;
		List<SystemRole> allSystemRoleList = new ArrayList<>();
		try {
			allSystemRoleIDList = EMPLOYEE_DAO.getAllSystemRoleIDList();
			for (Integer id : allSystemRoleIDList) {
				EMPLOYEE_DAO.getSystemRoleByID(id).ifPresent(allSystemRoleList::add);
			}
		} catch (DaoException e) {
			LOGGER.warn("Fail to get system role because " + e.getMessage());
			throw new ServiceException("Fail to get employee.", e);
		}

		return allSystemRoleList;
	}

	@Override
	public List<CrewRole> getAllCrewRole() throws ServiceException {

		List<Integer> allCrewRoleIDList;
		List<CrewRole> allCrewRoleList = new ArrayList<>();
		try {
			allCrewRoleIDList = EMPLOYEE_DAO.getAllCrewRoleIDList();
			for (Integer id : allCrewRoleIDList) {
				EMPLOYEE_DAO.getCrewRoleByID(id).ifPresent(allCrewRoleList::add);
			}
		} catch (DaoException e) {
			LOGGER.warn("Fail to get crew role because " + e.getMessage());
			throw new ServiceException("Fail to get employee.", e);
		}

		return allCrewRoleList;
	}

	@Override
	public boolean addEmployee(Optional<Object> objectOptional) throws ServiceException {

		boolean successFlag = false;

		try {
			ValidatorsEnum.EMPLOYEE_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e) {
			LOGGER.debug("Wrong employee parameters");
			throw new ServiceException("Wrong employee parameters", e);
		}

		Optional<Employee> employeeOptional = objectOptional.map(Employee.class::cast);

		try {
			successFlag = EMPLOYEE_DAO.addEmployee(employeeOptional);
		} catch (DaoException e) {
			LOGGER.debug("Can't add emoloyee because " + e.getMessage());
			throw new ServiceException("Can't add emoloyee", e);
		}
		
		return successFlag;
	}

	@Override
	public Optional<SystemRole> getSystemRoleByID(int ID) throws ServiceException {

		Optional<SystemRole> systemRole = Optional.empty();

		try {
			systemRole = EMPLOYEE_DAO.getSystemRoleByID(ID);
		} catch (DaoException e) {
			LOGGER.debug("Fail to get system role because " + e.getMessage());
			throw new ServiceException("Fail to get system role", e);
		}

		return systemRole;
	}

	@Override
	public Optional<CrewRole> getCrewRoleByID(int ID) throws ServiceException {

		Optional<CrewRole> crewRole = Optional.empty();

		try {
			crewRole = EMPLOYEE_DAO.getCrewRoleByID(ID);
		} catch (DaoException e) {
			LOGGER.debug("Fail to get crew role because " + e.getMessage());
			throw new ServiceException("Fail to get crew role", e);
		}

		return crewRole;
	}

	@Override
	public boolean updatePassword(Optional<String> employeePasswordOptional, Optional<char[]> passwordSequenceOptional)
			throws ServiceException {

		boolean successFlag = false;

		Optional<String> passwordOptional = passwordSequenceOptional.map(HASH_GENERATOR::getMD5Hash);

		try {
			successFlag = EMPLOYEE_DAO.updatePassword(employeePasswordOptional, passwordOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail change password");
			throw new ServiceException("Fail change password", e);
		}

		return successFlag;
	}

	@Override
	public boolean updateEmployeeInfo(Optional<Object> objectOptional) throws ServiceException {

		boolean successFlag = false;

		try {
			ValidatorsEnum.EMPLOYEE_VALIDATOR.getValidator().check(objectOptional);
		} catch (ValidatorException e) {
			LOGGER.debug("Wrong employee parameters");
			throw new ServiceException("Wrong employee parameters", e);
		}

		Optional<Employee> employeeOptional = objectOptional.map(Employee.class::cast);

		try {
			EMPLOYEE_DAO.updateEmployeeInfo(employeeOptional);
		} catch (DaoException e) {
			LOGGER.debug("Fail update employee info");
			throw new ServiceException("Fail update employee info", e);
		}

		return successFlag;
	}

	@Override
	public Optional<Employee> getEmployeeById(int Id) throws ServiceException {

		Optional<Employee> employeeOptional = Optional.empty();

		LOGGER.debug("id = " + Id);

		if (Id == 0) {
			LOGGER.debug("default user has been returned");
			return getDefaultUser();
		}

		try {
			employeeOptional = EMPLOYEE_DAO.getEmployeeByID(Id);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the employee");
			throw new ServiceException("Fail get the employee", e);
		}

		employeeOptional.ifPresent(e -> LOGGER.debug(e.getFirstName() + " " + e.getLastName()));

		return employeeOptional;
	}

	@Override
	public boolean deleteEmployee(Optional<String> employeeId) throws ServiceException {

		boolean successFlag = false;

		try {
			successFlag = EMPLOYEE_DAO.deleteEmployee(employeeId);
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the employee");
			throw new ServiceException("Fail delete the employee", e);
		}

		return successFlag;
	}

	private Optional<Employee> getDefaultUser() {

		Employee employee = new Employee();

		employee.setId(DEFAULT_ID);
		employee.setNickname(StringConstant.GUEST.getValue());
		employee.setFirstName(StringConstant.UNREGISTERED.getValue());
		employee.setLastName(StringConstant.USER.getValue());
		employee.setSystemRole(getDefaultSystemRole());
		employee.setCrewRole(getDefaultCrewRole());

		return Optional.of(employee);
	}

	private SystemRole getDefaultSystemRole() {

		SystemRole systemRole = new SystemRole();
		systemRole.setSystemRoleID(DEFAULT_ID);
		systemRole.setSystemRoleName(DEFAULT_NAME);

		return systemRole;
	}

	private CrewRole getDefaultCrewRole() {

		CrewRole crewRole = new CrewRole();
		crewRole.setCrewRoleID(DEFAULT_ID);
		crewRole.setCrewRoleName(DEFAULT_NAME);

		return crewRole;
	}
}
