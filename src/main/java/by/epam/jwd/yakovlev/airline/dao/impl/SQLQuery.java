package by.epam.jwd.yakovlev.airline.dao.impl;

public enum SQLQuery {
    GET_PASSWORD_BY_NICKNAME("SELECT employee_password FROM employee WHERE employee_nickname = ?"),
    GET_EMPLOYEE_BY_NICKNAME("SELECT `employee`.`employee_id`,\n" +
            "    `employee`.`employee_first_name`,\n" +
            "    `employee`.`employee_last_name`,\n" +
            "    `employee`.`system_role_id`,\n" +
            "    `employee`.`employee_nickname`,\n" +
            "    `employee`.`crew_role_id`\n" +
            "FROM `airlineproject`.`employee`" +
            "WHERE employee_nickname = ?"),
    GET_EMPLOYEE_BY_ID ("SELECT * FROM employee WHERE employee_id = ?"),
    ADD_AIRCRAFT_MODEL("INSERT INTO `aircraft_model`(`aircraft_model_id`, `aircraft_model_name`, `aircraft_model_capasity`)" +
            "VALUES (?, ?, ?)"),
    GET_ALL_AIRCRAFT_MODELS("SELECT * FROM aircraft_model"),
    GET_ALL_SYSTEM_ROLES ("SELECT * FROM system_role"),
    GET_ALL_CREW_ROLE ("SELECT * FROM crew_role"),
    GET_ALL_EMPLOYEE ("SELECT * FROM employee"),
    GET_SYSTEM_ROLE_BY_ID ("SELECT * FROM system_role WHERE system_role_id = ?"),
    GET_CREW_ROLE_BY_ID ("SELECT * FROM crew_role WHERE crew_role_id = ?"),
    GET_ALL_EMPLOYEE_ID ("SELECT employee_id FROM employee");

    private String query;

    SQLQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
