package by.epam.jwd.yakovlev.airline.dao.impl;

import by.epam.jwd.yakovlev.airline.builder.CrewRoleBuilder;
import by.epam.jwd.yakovlev.airline.builder.EmployeeBuilder;
import by.epam.jwd.yakovlev.airline.builder.SystemRoleBuilder;
import by.epam.jwd.yakovlev.airline.dao.EmployeeDAO;
import by.epam.jwd.yakovlev.airline.dao.impl.util.DAOUtil;
import by.epam.jwd.yakovlev.airline.entity.CrewRole;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.entity.SystemRole;
import by.epam.jwd.yakovlev.airline.exception.DaoException;

import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import java.util.*;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger LOGGER = Logger.getLogger(EmployeeDAOImpl.class);

    private static final SystemRoleBuilder SYSTEM_ROLE_BUILDER = SystemRoleBuilder.INSTANCE;
    private static final CrewRoleBuilder CREW_ROLE_BUILDER = CrewRoleBuilder.INSTANCE;
    private static final DAOUtil DAO_UTIL = DAOUtil.INSTANCE;
    private static final String[] EMPTY_QUERY_PARAMETERS = new String[0];

    private Set<Optional<SystemRole>> systemRoleSet = new HashSet<>();
    private Set<Optional<CrewRole>> crewRoleSet = new HashSet<>();
    private Set<Optional<Employee>> employeeSet = new HashSet<>();

    @Override
    public Optional<Employee> getEmployeeByNickname(String nickname) throws DaoException {
        EmployeeBuilder EMPLOYEE_BUILDER = EmployeeBuilder.INSTANCE;
        if (nickname == null) {
            return Optional.empty();
        }

        for (Optional<Employee> o : employeeSet) {
            if (o.isPresent() && o.get().getNickname() == nickname) {
                return o;
            }
        }

        Optional<Employee> optionalEmployee;
        String[] parameter = {nickname};

        Set<Properties> properties = DAO_UTIL.doSelectQuery(SQLQuery.GET_EMPLOYEE_BY_NICKNAME.getQuery(), parameter);

        if (properties.size() < 1) {
            return Optional.empty();
        }

        Properties employeeProperties = properties.iterator().next();

        optionalEmployee = EMPLOYEE_BUILDER.build(employeeProperties);

        if (optionalEmployee.isPresent()) {
            employeeSet.add(optionalEmployee);
        }

        return optionalEmployee;
    }

    @Override
    public Optional<Employee> getEmployeeByID(int ID) throws DaoException {
        EmployeeBuilder EMPLOYEE_BUILDER = EmployeeBuilder.INSTANCE;
        for (Optional<Employee> o : employeeSet) {
            if (o.isPresent() && o.get().getId() == ID) {
                return o;
            }
        }

        Optional<Employee> optionalEmployee;
        String[] parameter = {String.valueOf(ID)};

        Set<Properties> properties = DAO_UTIL.doSelectQuery(SQLQuery.GET_EMPLOYEE_BY_ID.getQuery(), parameter);

        if (properties.size() < 1) {
            return Optional.empty();
        }

        Properties employeeProperties = properties.iterator().next();

        optionalEmployee = EMPLOYEE_BUILDER.build(employeeProperties);

        if (optionalEmployee.isPresent()) {
            employeeSet.add(optionalEmployee);
        }

        return optionalEmployee;
    }

    @Override
    public Optional<String> getEmployeePasswordByNicName(String nickname) throws DaoException {

        if (nickname == null) {
            return Optional.empty();
        }

        Optional<String> password = Optional.empty();
        String[] parameter = {nickname};

        Set<Properties> properties = DAO_UTIL.doSelectQuery(SQLQuery.GET_PASSWORD_BY_NICKNAME.getQuery(), parameter);

        if (properties.size() < 1) {
            return Optional.empty();
        }

        Properties property = properties.iterator().next();

        String passwordHash = property.getProperty(StringConstant.EMPLOYEE_PASSWORD_KEY.getValue());
        if (passwordHash != null) {
            password = Optional.of(passwordHash);
        }

        return password;
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
    public boolean updateEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return false;
    }

    @Override
    public void addEmployee(Map<String, String> employee) throws DaoException {

        String query = SQLQuery.ADD_EMPLOYEE.getQuery();
        String[] queryParameters = new String[6];

        queryParameters[0] = employee.get(StringConstant.EMPLOYEE_FIRST_NAME_KEY.getValue());
        queryParameters[1] = employee.get(StringConstant.EMPLOYEE_LAST_NAME_KEY.getValue());
        queryParameters[2] = employee.get(StringConstant.SYSTEM_ROLE_ID_KEY.getValue());
        queryParameters[3] = employee.get(StringConstant.EMPLOYEE_NICKNAME_KEY.getValue());
        queryParameters[4] = employee.get(StringConstant.EMPLOYEE_PASSWORD_KEY.getValue());
        queryParameters[5] = employee.get(StringConstant.CREW_ROLE_ID_KEY.getValue());

        DAO_UTIL.doAddQuery(query, queryParameters);
    }

    @Override
    public Optional<SystemRole> getSystemRoleByID(int ID) throws DaoException {

        int temporaryID;
        for (Optional<SystemRole> o : systemRoleSet) {
            if (o.isPresent() && o.get().getSystemRoleID() == ID) {
                return o;
            }
        }

        String[] parameter = {String.valueOf(ID)};

        Set<Properties> systemRolePropertySet =
                DAO_UTIL.doSelectQuery(SQLQuery.GET_SYSTEM_ROLE_BY_ID.getQuery(), parameter);

        if (systemRolePropertySet.size() < 1) {
            return Optional.empty();
        }

        Properties property = systemRolePropertySet.iterator().next();

        Optional<SystemRole> systemRole = SYSTEM_ROLE_BUILDER.build(property);

        if (systemRole.isPresent()) {
            systemRoleSet.add(systemRole);
        }

        return systemRole;
    }

    @Override
    public Optional<CrewRole> getCrewRoleByID(int ID) throws DaoException {

        for (Optional<CrewRole> o : crewRoleSet) {
            if (o.isPresent() && o.get().getCrewRoleID() == ID) {
                return o;
            }
        }

        String[] parameter = {String.valueOf(ID)};

        Set<Properties> crewRolePropertySet =
                DAO_UTIL.doSelectQuery(SQLQuery.GET_CREW_ROLE_BY_ID.getQuery(), parameter);

        if (crewRolePropertySet.size() < 1) {
            return Optional.empty();
        }

        Properties property = crewRolePropertySet.iterator().next();

        Optional<CrewRole> crewRole = CREW_ROLE_BUILDER.build(property);

        if (crewRole.isPresent()) {
            crewRoleSet.add(crewRole);
        }

        return crewRole;
    }

    private List<Integer> getIDList(String query, String propertyKey) throws DaoException {

        Set<Properties> propertiesSet = DAO_UTIL.doSelectQuery(query, EMPTY_QUERY_PARAMETERS);

        List<Integer> setOfID = new ArrayList<>();
        for (Properties p : propertiesSet) {
            setOfID.add(Integer.valueOf(p.getProperty(propertyKey)));
        }

        return setOfID;
    }
}