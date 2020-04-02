package by.epam.jwd.yakovlev.airline.validator;

import by.epam.jwd.yakovlev.airline.exception.ValidatorException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum EmployeeValidator {
    INSTANCE;

    public void checkSystemRoleProperties(Properties properties) throws ValidatorException {

        if (properties == null) {
            throw new ValidatorException("System role has invalid properties");
        }

        String systemRoleIDString = properties.getProperty(StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
        String systemRoleNameString = properties.getProperty(StringConstant.SYSTEM_ROLE_NAME_KEY.getValue());

        if (!isInteger(systemRoleIDString)) {
            throw new ValidatorException("Employee ID must be integer.");
        }
        if (!isPatternMatches(RegexPatterns.NAME, systemRoleNameString)) {
            throw new ValidatorException("Employee first name is invalid.");
        }
    }

    public void checkCrewRoleProperties(Properties properties) throws ValidatorException {

        if (properties == null) {
            throw new ValidatorException("Crew role has invalid properties");
        }

        String crewRoleIDString = properties.getProperty(StringConstant.CREW_ROLE_ID_KEY.getValue());
        String crewRoleNameString = properties.getProperty(StringConstant.CREW_ROLE_NAME_KEY.getValue());

        if (!isInteger(crewRoleIDString)) {
            throw new ValidatorException("Employee ID must be integer.");
        }
        if (!isPatternMatches(RegexPatterns.NAME, crewRoleNameString)) {
            throw new ValidatorException("Employee first name is invalid.");
        }
    }

    public void checkEmployeeProperties(Properties properties) throws ValidatorException {

        if (properties == null) {
            throw new ValidatorException("Employee has invalid properties");
        }

        String employeeFirstName = properties.getProperty(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue());
        String employeeLastName = properties.getProperty(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue());
        String employeeNickname = properties.getProperty(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue());
        String employeeIDString = properties.getProperty(StringConstant.EMPLOYEE_ID_KEY.getValue());
        String employeeSystemRoleIDString = properties.getProperty(StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
        String employeeCrewRoleIDString = properties.getProperty(StringConstant.CREW_ROLE_ID_KEY.getValue());

        if (!isPatternMatches(RegexPatterns.NAME, employeeFirstName)) {
            throw new ValidatorException("Employee first name is invalid.");
        }
        if (!isPatternMatches(RegexPatterns.NAME, employeeLastName)) {
            throw new ValidatorException("Employee last name is invalid.");
        }
        if (!isPatternMatches(RegexPatterns.NAME, employeeNickname)) {
            throw new ValidatorException("Employee system user name is invalid.");
        }
        if (!isInteger(employeeIDString)) {
            throw new ValidatorException("Employee ID must be integer.");
        }
        if (!isInteger(employeeSystemRoleIDString)) {
            throw new ValidatorException("System role ID must be integer.");
        }
        if (!isInteger(employeeCrewRoleIDString)) {
            throw new ValidatorException("Crew role ID must be integer.");
        }
    }

    private boolean isPatternMatches(RegexPatterns regex, String word) {

        if (word == null) {
            return false;
        }

        Pattern pattern = regex.getPattern();
        Matcher matcher = pattern.matcher(word);

        return matcher.matches();
    }

    private boolean isInteger(String string) {

        if (string == null) {
            return false;
        }

        try {
            int systemRoleID = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
