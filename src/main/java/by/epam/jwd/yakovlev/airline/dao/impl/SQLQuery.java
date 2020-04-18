package by.epam.jwd.yakovlev.airline.dao.impl;

public enum SQLQuery {
    GET_PASSWORD_BY_NICKNAME("SELECT employee_password FROM employee WHERE employee_nickname = ?"),
    GET_EMPLOYEE_BY_NICKNAME("SELECT `employee`.`employee_id`," +
            "`employee`.`employee_first_name`," +
            "`employee`.`employee_last_name`," +
            "`employee`.`system_role_id`," +
            "`employee`.`employee_nickname`," +
            "`employee`.`crew_role_id`" +
            "FROM `airlineproject`.`employee`" +
            "WHERE employee_nickname = ?"),
    GET_EMPLOYEE_BY_NICKNAME_AND_PASSWORD("SELECT `employee`.`employee_id`," +
            "`employee`.`employee_first_name`," +
            "`employee`.`employee_last_name`," +
            "`employee`.`system_role_id`," +
            "`employee`.`employee_nickname`," +
            "`employee`.`crew_role_id`" +
            "FROM `airlineproject`.`employee`" +
            "WHERE employee_nickname = ? AND employee_password = ?"),    
    GET_EMPLOYEE_BY_ID ("SELECT * FROM employee WHERE employee_id = ?"),
    GET_ALL_AIRCRAFT_MODELS("SELECT * FROM aircraft_model"),
    GET_ALL_AIRCRAFTS("SELECT `aircraft`.`aircraft_id`,\r\n" + 
    		"    `aircraft`.`aircraft_model_id`,\r\n" + 
    		"    `aircraft`.`aircraft_side_number`,\r\n" + 
    		"    `aircraft_model`.`aircraft_model_name`,\r\n" + 
    		"    `aircraft_model`.`aircraft_model_capacity`\r\n" + 
    		" FROM `airlineproject`.`aircraft` \r\n" + 
    		" JOIN `airlineproject`.`aircraft_model`\r\n" + 
    		" ON `airlineproject`.`aircraft`.`aircraft_model_id` = `airlineproject`.`aircraft_model`.`aircraft_model_id`;"),
    GET_ALL_SYSTEM_ROLES ("SELECT * FROM system_role"),
    GET_ALL_CREW_ROLE ("SELECT * FROM crew_role"),
    GET_ALL_EMPLOYEE ("SELECT * FROM employee"),
    GET_SYSTEM_ROLE_BY_ID ("SELECT * FROM system_role WHERE system_role_id = ?"),
    GET_CREW_ROLE_BY_ID ("SELECT * FROM crew_role WHERE crew_role_id = ?"),
    GET_AIRCRAFT_MODEL_BY_ID ("SELECT * FROM aircraft_model WHERE aircraft_model_id = ?"),
    GET_AIRCRAFT_BY_ID("SELECT `aircraft`.`aircraft_id`,\r\n" + 
    		"    `aircraft`.`aircraft_model_id`,\r\n" + 
    		"    `aircraft`.`aircraft_side_number`,\r\n" + 
    		"    `aircraft_model`.`aircraft_model_name`,\r\n" + 
    		"    `aircraft_model`.`aircraft_model_capacity`\r\n" + 
    		" FROM `airlineproject`.`aircraft` \r\n" + 
    		" JOIN `airlineproject`.`aircraft_model`\r\n" + 
    		" ON `airlineproject`.`aircraft`.`aircraft_model_id` = `airlineproject`.`aircraft_model`.`aircraft_model_id`\r\n" + 
    		" WHERE `aircraft`.`aircraft_id` = ?;"),
    GET_ALL_EMPLOYEE_ID ("SELECT employee_id FROM employee"),
    GET_ALL_SYSTEM_ROLE_ID ("SELECT system_role_id FROM system_role"),
    GET_ALL_CREW_ROLE_ID ("SELECT crew_role_id FROM crew_role"),
    ADD_EMPLOYEE ("INSERT INTO `employee` (" +
            "`employee_first_name`," +
            "`employee_last_name`," +
            "`system_role_id`," +
            "`employee_nickname`," +
            "`employee_password`," +
            "`crew_role_id`) " +
            "VALUES (?, ?, ?, ?, ?, ?);"),
    ADD_AIRCRAFT_MODEL("INSERT INTO `aircraft_model`(`aircraft_model_name`, `aircraft_model_capacity`)" +
    		"VALUES (?, ?)"),
    ADD_AIRCRAFT("INSERT INTO `aircraft`(`aircraft_model_id`, `aircraft_side_number`)" +
    		"VALUES (?, ?)"),
    DELETE_EMPLOYEE ("DELETE FROM `employee` WHERE (`employee_id` = ?);"),
    DELETE_AIRCRAFT_MODEL ("DELETE FROM `aircraft_model` WHERE (`aircraft_model_id` = ?);"),
    DELETE_AIRCRAFT ("DELETE FROM `aircraft` WHERE (`aircraft_id` = ?);"),
    UPDATE_AIRCRAFT_MODEL_INFO ("UPDATE `aircraft_model` "
			+ "SET `aircraft_model_name` = ?, "
			+ "`aircraft_model_capacity` = ? "
			+ "WHERE `aircraft_model_id` = ?;"),
    UPDATE_AIRCRAFT_INFO ("UPDATE `aircraft` "
			+ "SET `aircraft_model_id` = ?, "
			+ "`aircraft_side_number` = ? "
			+ "WHERE `aircraft_id` = ?;"),
    UPDATE_EMPLOYEE_PASSWORD ("UPDATE `employee` SET `employee_password` = ? WHERE `employee_id` = ?;"),
    UPDATE_EMPLOYEE_INFO ("UPDATE `employee` "
			+ "SET `employee_nickname` = ?, "
			+ "`employee_first_name` = ?, "
			+ "`employee_last_name` = ?, "
			+ "`system_role_id` = ?, "
			+ "`crew_role_id` = ? "
			+ "WHERE `employee_id` = ?;");

    private String query;

    SQLQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
