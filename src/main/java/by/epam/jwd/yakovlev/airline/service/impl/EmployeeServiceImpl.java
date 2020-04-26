package by.epam.jwd.yakovlev.airline.service.impl;

import by.epam.jwd.yakovlev.airline.dao.DAOFactory;
import by.epam.jwd.yakovlev.airline.dao.EmployeeDAO;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.DaoException;
import by.epam.jwd.yakovlev.airline.exception.ServiceException;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.EmployeeService;
import by.epam.jwd.yakovlev.airline.util.HashGenerator;
import by.epam.jwd.yakovlev.airline.validator.ValidatorFactory;

import java.util.*;

import org.apache.log4j.Logger;

public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = Logger.getLogger(EmployeeServiceImpl.class);
	private static final HashGenerator HASH_GENERATOR = new HashGenerator();
	private static final EmployeeDAO EMPLOYEE_DAO = DAOFactory.getInstance().getEmployeeDAO();

	@Override
	public Optional<Employee> login(String employeeNickname, char[] password) throws ServiceException {		

		if (employeeNickname == null || password == null) {
			return Optional.empty();
		}

		String passwordHash = HASH_GENERATOR.getMD5Hash(password);

		try {
			return EMPLOYEE_DAO.getEmployeeByNicknameAndPassword(employeeNickname, passwordHash);
		} catch (DaoException e) {
			LOGGER.warn("Can't get an employee", e);
			throw new ServiceException("Service failed", e);
		}
	}

	@Override
	public List<Employee> getAllEmployeesList() throws ServiceException {
		
		try {
			return EMPLOYEE_DAO.getAllEmployeesList();
		} catch (DaoException e) {
			LOGGER.warn("Fail to get employee", e);
			throw new ServiceException("Fail to get employee.", e);
		}
	}

	@Override
	public boolean addEmployee(Employee employee) throws ServiceException {

		checkEmployee(employee);

		try {
			return EMPLOYEE_DAO.addEmployee(Optional.of(employee));
		} catch (DaoException e) {
			LOGGER.debug("Can't add emoloyee because", e);
			throw new ServiceException("Can't add emoloyee", e);
		}
	}	

	@Override
	public boolean updatePassword(Employee employee, char[] newPasswordSequence)
			throws ServiceException {

		checkEmployee(employee);
		
		try {
			ValidatorFactory.getInstance().getPasswordValidator().check(newPasswordSequence);
		} catch (ValidatorException e) {
			LOGGER.debug("The password validation is fail", e);
			return false;
		}

		String passwordOptional = HASH_GENERATOR.getMD5Hash(newPasswordSequence);

		try {
			return EMPLOYEE_DAO.updatePassword(Optional.of(employee), Optional.of(passwordOptional));
		} catch (DaoException e) {
			LOGGER.debug("Fail change password", e);
			throw new ServiceException("Fail change password", e);
		}
	}

	@Override
	public boolean updateEmployee(Employee employee) throws ServiceException {

		checkEmployee(employee);

		try {
			return EMPLOYEE_DAO.updateEmployee(Optional.of(employee));
		} catch (DaoException e) {
			LOGGER.debug("Fail update employee info", e);
			throw new ServiceException("Fail update employee info", e);
		}
	}

	@Override
	public Optional<Employee> getEmployeeById(int id) throws ServiceException {

		if (id < 1) {
			return Optional.empty();
		}
		
		try {
			return EMPLOYEE_DAO.getEmployeeByID(id);
		} catch (DaoException e) {
			LOGGER.debug("Fail get the employee", e);
			throw new ServiceException("Fail get the employee", e);
		}
	}

	@Override
	public boolean deleteEmployee(Employee employee) throws ServiceException {
		
		checkEmployee(employee);
		
		try {
			return EMPLOYEE_DAO.deleteEmployee(Optional.of(employee));
		} catch (DaoException e) {
			LOGGER.debug("Fail delete the employee", e);
			throw new ServiceException("Fail delete the employee", e);
		}
	}
	
	private void checkEmployee(Employee employee) throws ServiceException{
		
		//LOGGER.debug("***");
		//EmployeeValidator validator = new EmployeeValidator();
		//LOGGER.debug("****");
		try {
			ValidatorFactory.getInstance().getEmployeeValidator().check(employee);
			//ValidatorFactoryEnum.INSTANCE.getEmployeeValidator().check(employee);
			//validator.check(employee);
		} catch (ValidatorException e) {
			LOGGER.debug("Wrong employee parameters", e);
			throw new ServiceException("Wrong employee parameters", e);
		}
	}
}
