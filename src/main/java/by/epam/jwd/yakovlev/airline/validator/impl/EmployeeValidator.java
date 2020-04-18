package by.epam.jwd.yakovlev.airline.validator.impl;

import java.util.Optional;

import org.apache.log4j.Logger;

import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.service.impl.EmployeeServiceImpl;
import by.epam.jwd.yakovlev.airline.validator.RegexPatterns;
import by.epam.jwd.yakovlev.airline.validator.Validator;

public class EmployeeValidator implements Validator {

	private static final Logger LOGGER = Logger.getLogger(EmployeeValidator.class);

	@Override
	public void check(Optional<Object> entityOptional) throws ValidatorException {

		if (!entityOptional.isPresent()) {
			LOGGER.debug("Null argument");
		}
		
		Object object = entityOptional.orElseThrow(() -> new ValidatorException("Null argument"));

		if (!(object instanceof Employee)) {
			LOGGER.debug("Employee failed validation");
			throw new ValidatorException("Wrong type argument");
		}

		Employee employee = (Employee) object;

		if (!isPatternMatches(RegexPatterns.NAME.getPattern(), employee.getFirstName())) {
			LOGGER.debug("Employee failed validation. Wrong first name - " + employee.getFirstName());
			throw new ValidatorException("The employee consists an incorrect data");
		}

		if (!isPatternMatches(RegexPatterns.NAME.getPattern(), employee.getLastName())) {
			LOGGER.debug("Employee failed validation. Wrong last name - " + employee.getLastName());
			throw new ValidatorException("The employee consists an incorrect data");
		}

		if (!isPatternMatches(RegexPatterns.WORD.getPattern(), employee.getNickname())) {
			LOGGER.debug("Employee failed validation. Wrong nickname - " + employee.getNickname());
			throw new ValidatorException("The employee consists an incorrect data");
		}

		if (employee.getSystemRole() == null) {
			LOGGER.debug("Employee failed validation. Wrong nickname");
			throw new ValidatorException("The employee consists an incorrect data");
		}
	}
}
