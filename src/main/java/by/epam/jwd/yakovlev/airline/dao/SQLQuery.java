package by.epam.jwd.yakovlev.airline.dao;

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
    GET_EMPLOYEE_BY_NICKNAME_AND_PASSWORD("SELECT `employee`.`employee_id`, " 
    		+ "`employee`.`employee_nickname`, " 
    		+ "`employee`.`employee_first_name`, " 
    		+ "`employee`.`employee_last_name`, " 
    		+ "`employee`.`system_role_id`, " 
    		+ "`system_role`.`system_role_name`, " 
    		+ "`employee`.`crew_role_id`, " 
    		+ "`crew_role`.`crew_role_name` " 
    		+ "FROM `airlineproject`.`employee` " 
    		+ "JOIN `system_role` " 
    		+ "ON `employee`.`system_role_id` = `system_role`.`system_role_id` " 
    		+ "JOIN `crew_role` " 
    		+ "ON `employee`.`crew_role_id` = `crew_role`.`crew_role_id` "
            + "WHERE employee_nickname = ? AND employee_password = ?"),
    GET_EMPLOYEE_BY_ID ("SELECT `employee`.`employee_id`, " 
    		+ "`employee`.`employee_nickname`, " 
    		+ "`employee`.`employee_first_name`, " 
    		+ "`employee`.`employee_last_name`, " 
    		+ "`employee`.`system_role_id`, " 
    		+ "`system_role`.`system_role_name`, " 
    		+ "`employee`.`crew_role_id`, " 
    		+ "`crew_role`.`crew_role_name` " 
    		+ "FROM `airlineproject`.`employee` " 
    		+ "JOIN `system_role` " 
    		+ "ON `employee`.`system_role_id` = `system_role`.`system_role_id` " 
    		+ "JOIN `crew_role` " 
    		+ "ON `employee`.`crew_role_id` = `crew_role`.`crew_role_id` "
            + "WHERE employee_id = ?"),
    GET_CREW_BY_FLIGHT_ID ("SELECT `employee`.`employee_id`,"
    		+ " `employee`.`employee_nickname`,"
    		+ " `employee`.`employee_first_name`,"
    		+ " `employee`.`employee_last_name`,"
    	    + " `employee`.`system_role_id`,"
    	    + " `system_role`.`system_role_name`,"
    	    + " `employee`.`crew_role_id`,"
    	    + " `crew_role`.`crew_role_name`,"
    	    + " `crew`.`flight_id`"
    	+ " FROM `airlineproject`.`employee`"
    	+ " JOIN `system_role`"
    	+ " ON `employee`.`system_role_id` = `system_role`.`system_role_id`"
    	+ " JOIN `crew_role`"
    	+ " ON `employee`.`crew_role_id` = `crew_role`.`crew_role_id`"
    	+ " JOIN `crew`"
    	+ " ON `crew`.`employee_id` = `employee`.`employee_id`"
    	+ " WHERE `crew`.`flight_id` = ?"),
    GET_ALL_AIRCRAFT_MODELS("SELECT * FROM aircraft_model"),
    GET_ALL_AIRCRAFTS("SELECT `aircraft`.`aircraft_id`,\r\n" + 
    		"    `aircraft`.`aircraft_model_id`,\r\n" + 
    		"    `aircraft`.`aircraft_side_number`,\r\n" + 
    		"    `aircraft_model`.`aircraft_model_name`,\r\n" + 
    		"    `aircraft_model`.`aircraft_model_capacity`\r\n" + 
    		" FROM `airlineproject`.`aircraft` \r\n" + 
    		" JOIN `airlineproject`.`aircraft_model`\r\n" + 
    		" ON `airlineproject`.`aircraft`.`aircraft_model_id` = `airlineproject`.`aircraft_model`.`aircraft_model_id`;"),
    GET_ALL_AIRPORTS ("SELECT * FROM airport"),
    GET_ALL_SYSTEM_ROLES ("SELECT * FROM system_role"),
    GET_ALL_CREW_ROLE ("SELECT * FROM crew_role"),
    GET_ALL_EMPLOYEE ("SELECT `employee`.`employee_id`, "
    		+ "`employee`.`employee_nickname`, "
    		+ "`employee`.`employee_first_name`, "
    		+ "`employee`.`employee_last_name`, "
    		+ "`employee`.`system_role_id`, "
    		+ "`system_role`.`system_role_name`, "
    		+ "`employee`.`crew_role_id`, "
    		+ "`crew_role`.`crew_role_name` "
    		+ "FROM `airlineproject`.`employee` "
    		+ "JOIN `system_role` "
    		+ "ON `employee`.`system_role_id` = `system_role`.`system_role_id` "
    		+ "JOIN `crew_role` "
    		+ "ON `employee`.`crew_role_id` = `crew_role`.`crew_role_id`;"),
    GET_SYSTEM_ROLE_BY_ID ("SELECT * FROM system_role WHERE system_role_id = ?"),
    GET_CREW_ROLE_BY_ID ("SELECT * FROM crew_role WHERE crew_role_id = ?"),
    GET_AIRPORT_BY_ID ("SELECT * FROM airport WHERE airport_id = ?"),
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
    ADD_AIRPORT ("INSERT INTO `airport`(`airport_city`)" +
    		"VALUES (?)"),
    ADD_SYSTEM_ROLE ("INSERT INTO `system_role`(`system_role_name`)" +
    		"VALUES (?)"),
    ADD_CREW_ROLE ("INSERT INTO `crew_role`(`crew_role_name`)" +
    		"VALUES (?)"),
    ADD_CREW_MEMBER ("INSERT INTO `crew`(`flight_id`, `employee_id`)" +
    		"VALUES (?, ?)"),
    DELETE_EMPLOYEE ("DELETE FROM `employee` WHERE (`employee_id` = ?);"),
    DELETE_AIRCRAFT_MODEL ("DELETE FROM `aircraft_model` WHERE (`aircraft_model_id` = ?);"),
    DELETE_AIRCRAFT ("DELETE FROM `aircraft` WHERE (`aircraft_id` = ?);"),
    DELETE_AIRPORT ("DELETE FROM `airport` WHERE (`airport_id` = ?);"),
    DELETE_SYSTEM_ROLE ("DELETE FROM `system_role` WHERE (`system_role_id` = ?);"),
    DELETE_CREW_ROLE ("DELETE FROM `crew_role` WHERE (`crew_role_id` = ?);"),
    DELETE_CREW_MEMBER ("DELETE FROM `crew` WHERE (`flight_id` = ? AND `employee_id` = ?);"),
    UPDATE_AIRCRAFT_MODEL ("UPDATE `aircraft_model` "
			+ "SET `aircraft_model_name` = ?, "
			+ "`aircraft_model_capacity` = ? "
			+ "WHERE `aircraft_model_id` = ?;"),
    UPDATE_AIRCRAFT ("UPDATE `aircraft` "
			+ "SET `aircraft_model_id` = ?, "
			+ "`aircraft_side_number` = ? "
			+ "WHERE `aircraft_id` = ?;"),
    UPDATE_AIRPORT ("UPDATE `airport` SET `airport_city` = ? WHERE `airport_id` = ?;"),
    UPDATE_SYSTEM_ROLE ("UPDATE `system_role` SET `system_role_name` = ? WHERE `system_role_id` = ?;"),
    UPDATE_CREW_ROLE ("UPDATE `crew_role` SET `crew_role_name` = ? WHERE `crew_role_id` = ?;"),
    UPDATE_EMPLOYEE_PASSWORD ("UPDATE `employee` SET `employee_password` = ? WHERE `employee_id` = ?;"),
    UPDATE_EMPLOYEE ("UPDATE `employee` "
			+ "SET `employee_nickname` = ?, "
			+ "`employee_first_name` = ?, "
			+ "`employee_last_name` = ?, "
			+ "`system_role_id` = ?, "
			+ "`crew_role_id` = ? "
			+ "WHERE `employee_id` = ?;"),
    GET_FLIGHT_BY_ID ("SELECT A.`flight_id`, "
    		+ "A.`flight_departure_time` flight_departure_time, "
    		+ "A.`flight_landing_time` flight_landing_time, "
    		+ "A.`flight_aircraft_id` aircraft_id, "
    		+ "D.`aircraft_side_number` aircraft_side_number, "
    		+ "D.`aircraft_model_id` aircraft_model_id, "
    		+ "E.`aircraft_model_name` aircraft_model_name, "
    		+ "E.`aircraft_model_capacity` aircraft_model_capacity, "
    		+ "A.`flight_departure_airport_id` flight_departure_airport_id, "
    		+ "B.`airport_city` flight_departure_airport_city, "
    		+ "A.`flight_destination_airport_id` flight_destination_airport_id, "
    		+ "C.`airport_city` flight_destination_airport_city "
    		+ "FROM `flight` A "
    		+ "JOIN `airport` B "
    		+ "ON A.`flight_departure_airport_id` = B.`airport_id` "
    		+ "JOIN `airport` C "
    		+ "ON A.`flight_destination_airport_id` = C.`airport_id` "
    		+ "JOIN `aircraft` D "
    		+ "ON A.`flight_aircraft_id` = D.`aircraft_id` "
    		+ "JOIN `aircraft_model` E "
    		+ "ON D.`aircraft_model_id` = E.`aircraft_model_id` "
    		+ "WHERE A.`flight_id` = ?;"),
	GET_ALL_FLIGHTS ("SELECT A.`flight_id`, "
			+ "A.`flight_departure_time` flight_departure_time, "
			+ "A.`flight_landing_time` flight_landing_time, "
			+ "A.`flight_aircraft_id` aircraft_id, "
			+ "D.`aircraft_side_number` aircraft_side_number, "
			+ "D.`aircraft_model_id` aircraft_model_id, "
			+ "E.`aircraft_model_name` aircraft_model_name, "
			+ "E.`aircraft_model_capacity` aircraft_model_capacity, "
			+ "A.`flight_departure_airport_id` flight_departure_airport_id, "
			+ "B.`airport_city` flight_departure_airport_city, "
			+ "A.`flight_destination_airport_id` flight_destination_airport_id, "
			+ "C.`airport_city` flight_destination_airport_city "
			+ "FROM `flight` A "
			+ "JOIN `airport` B "
			+ "ON A.`flight_departure_airport_id` = B.`airport_id` "
			+ "JOIN `airport` C "
			+ "ON A.`flight_destination_airport_id` = C.`airport_id` "
			+ "JOIN `aircraft` D "
			+ "ON A.`flight_aircraft_id` = D.`aircraft_id` "
			+ "JOIN `aircraft_model` E "
			+ "ON D.`aircraft_model_id` = E.`aircraft_model_id`;"),
	GET_FLIGHTS_BETWEEN_DATES ("SELECT A.`flight_id`, "
			+ "A.`flight_departure_time` flight_departure_time, "
			+ "A.`flight_landing_time` flight_landing_time, "
			+ "A.`flight_aircraft_id` aircraft_id, "
			+ "D.`aircraft_side_number` aircraft_side_number, "
			+ "D.`aircraft_model_id` aircraft_model_id, "
			+ "E.`aircraft_model_name` aircraft_model_name, "
			+ "E.`aircraft_model_capacity` aircraft_model_capacity, "
			+ "A.`flight_departure_airport_id` flight_departure_airport_id, "
			+ "B.`airport_city` flight_departure_airport_city, "
			+ "A.`flight_destination_airport_id` flight_destination_airport_id, "
			+ "C.`airport_city` flight_destination_airport_city "
			+ "FROM `flight` A "
			+ "JOIN `airport` B "
			+ "ON A.`flight_departure_airport_id` = B.`airport_id` "
			+ "JOIN `airport` C "
			+ "ON A.`flight_destination_airport_id` = C.`airport_id` "
			+ "JOIN `aircraft` D "
			+ "ON A.`flight_aircraft_id` = D.`aircraft_id` "
			+ "JOIN `aircraft_model` E "
			+ "ON D.`aircraft_model_id` = E.`aircraft_model_id`"
			+ "WHERE `flight_departure_time` > ?" 
			+ "AND" 
			+ "`flight_landing_time` < ?;"),
	GET_YOUNGEST_FLIGHT ("SELECT A.`flight_id`, "
			+ "A.`flight_departure_time` flight_departure_time, "
			+ "A.`flight_landing_time` flight_landing_time, "
			+ "A.`flight_aircraft_id` aircraft_id, "
			+ "D.`aircraft_side_number` aircraft_side_number, "
			+ "D.`aircraft_model_id` aircraft_model_id, "
			+ "E.`aircraft_model_name` aircraft_model_name, "
			+ "E.`aircraft_model_capacity` aircraft_model_capacity, "
			+ "A.`flight_departure_airport_id` flight_departure_airport_id, "
			+ "B.`airport_city` flight_departure_airport_city, "
			+ "A.`flight_destination_airport_id` flight_destination_airport_id, "
			+ "C.`airport_city` flight_destination_airport_city "
			+ "FROM `flight` A "
			+ "JOIN `airport` B "
			+ "ON A.`flight_departure_airport_id` = B.`airport_id` "
			+ "JOIN `airport` C "
			+ "ON A.`flight_destination_airport_id` = C.`airport_id` "
			+ "JOIN `aircraft` D "
			+ "ON A.`flight_aircraft_id` = D.`aircraft_id` "
			+ "JOIN `aircraft_model` E "
			+ "ON D.`aircraft_model_id` = E.`aircraft_model_id`"
			+ "WHERE `flight_departure_time` = " 
			+ "(SELECT MIN(`flight_departure_time`) FROM `flight`);"),
	GET_OLDEST_FLIGHT ("SELECT A.`flight_id`, "
			+ "A.`flight_departure_time` flight_departure_time, "
			+ "A.`flight_landing_time` flight_landing_time, "
			+ "A.`flight_aircraft_id` aircraft_id, "
			+ "D.`aircraft_side_number` aircraft_side_number, "
			+ "D.`aircraft_model_id` aircraft_model_id, "
			+ "E.`aircraft_model_name` aircraft_model_name, "
			+ "E.`aircraft_model_capacity` aircraft_model_capacity, "
			+ "A.`flight_departure_airport_id` flight_departure_airport_id, "
			+ "B.`airport_city` flight_departure_airport_city, "
			+ "A.`flight_destination_airport_id` flight_destination_airport_id, "
			+ "C.`airport_city` flight_destination_airport_city "
			+ "FROM `flight` A "
			+ "JOIN `airport` B "
			+ "ON A.`flight_departure_airport_id` = B.`airport_id` "
			+ "JOIN `airport` C "
			+ "ON A.`flight_destination_airport_id` = C.`airport_id` "
			+ "JOIN `aircraft` D "
			+ "ON A.`flight_aircraft_id` = D.`aircraft_id` "
			+ "JOIN `aircraft_model` E "
			+ "ON D.`aircraft_model_id` = E.`aircraft_model_id`"
			+ "WHERE `flight_departure_time` = " 
			+ "(SELECT MAX(`flight_departure_time`) FROM `flight`);"),
    UPDATE_FLIGHT ("UPDATE `flight` "
			+ "SET `flight_departure_time` = ?, "
			+ "`flight_landing_time` = ?, "
			+ "`flight_aircraft_id` = ?, "
			+ "`flight_departure_airport_id` = ?, "
			+ "`flight_destination_airport_id` = ? "
			+ "WHERE `flight_id` = ?;"),
    DELETE_FLIGHT ("DELETE FROM `flight` WHERE (`flight_id` = ?);"),
    ADD_FLIGHT ("INSERT INTO `flight`(`flight_departure_time`, "
    		+ "`flight_landing_time`, "
    		+ "`flight_aircraft_id`, "
    		+ "`flight_departure_airport_id`, "
    		+ "`flight_destination_airport_id`)"
    		+ "VALUES (?, ?, ?, ?, ?)");

    private String query;

    SQLQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
