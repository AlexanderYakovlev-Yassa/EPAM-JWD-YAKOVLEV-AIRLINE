package by.epam.jwd.yakovlev.airline.util;

public enum StringConstant {
    AIRPORT_ID_KEY ("airport_id"),
    AIRCRAFT_KEY ("aircraft"),
    AIRCRAFT_ID_KEY ("aircraft_id"),
    AIRCRAFT_SIDE_NUMBER_KEY ("aircraft_side_number"),
    AIRCRAFT_MODEL_ID_KEY ("aircraft_model_id"),
    AIRCRAFT_MODEL_NAME_KEY ("aircraft_model_name"),
    AIRCRAFT_MODEL_CAPACITY_KEY ("aircraft_model_capacity"),
    AIRPORT_CITY_KEY ("airport_city"),
    ALL_EMPLOYEE_LIST_KEY ("all_employee_list"),
    ALL_SYSTEM_ROLE_LIST_KEY ("all_system_role_list"),
    ALL_CREW_ROLE_LIST_KEY ("all_crew_role_list"),
    ALL_AIRCRAFTS_LIST_KEY ("all_aircrafts_list"),
    ALL_AIRCRAFT_MODELS_LIST_KEY ("all_aircraft_models_list"),
    ALL_AIRPORTS_LIST_KEY ("all_airports_list"),
    ALL_FLIGHTS_LIST_KEY ("all_flights_list"),
    COMMAND_KEY ("command"),
    CURRENT_SESSION_USER_KEY ("current_session_user"),
    CURRENT_SESSION_ROLE_KEY ("current_session_role"),
    CURRENT_PAGE ("current_page"),
    CREW_ROLE_KEY ("crew_role"),
    CREW_ROLE_ID_KEY ("crew_role_id"),
    CREW_ROLE_NAME_KEY ("crew_role_name"),
    DATE_TIME_LONG_FORMAT ("yyyy-MM-dd HH:mm:ss"),
    DATE_TIME_SHORT_FORMAT ("dd-MM-yyyy HH:mm"),
    DEPARTURE_AIRPORT_ID_KEY ("departure_airport_id"),
    DESTINATION_AIRPORT_ID_KEY ("destination_airport_id"),
    EMPLOYEE_ID_KEY ("employee_id"),
    EMPLOYEE_FIRST_NAME_KEY("employee_first_name"),
    EMPLOYEE_LAST_NAME_KEY("employee_last_name"),
    EMPLOYEE_NICKNAME_KEY ("employee_nickname"),
    EMPLOYEE_PASSWORD_KEY("employee_password"),
    EMPTY_STRING (""),
    FAIL ("fail"),
    FLIGHT_ID_KEY ("flight_id"),
    FLIGHT_DEPARTURE_TIME_KEY ("flight_departure_time"),
    FLIGHT_LANDING_TIME_KEY ("flight_landing_time"),
    FLIGHT_LANDING_AIRPORT_ID_KEY ("flight_destination_airport_id"),
    FLIGHT_AIRCRAFT_ID_KEY ("flight_aircraft_id"),
    FLIGHT_AIRCRAFT_SIDE_NUMBER_KEY ("flight_aircraft_side_number"),
    FLIGHT_AIRCRAFT_MODEL_ID_KEY ("flight_aircraft_model_id"),
    FLIGHT_AIRCRAFT_MODEL_NAME_KEY ("flight_aircraft_model_name"),
    FLIGHT_AIRCRAFT_MODEL_CAPACITY_KEY ("flight_aircraft_model_capacity"),
    FLIGHT_DEPARTURE_AIRPORT_ID_KEY ("flight_departure_airport_id"),
    FLIGHT_DEPARTURE_AIRPORT_CITY_KEY ("flight_departure_airport_city"),
    FLIGHT_DESTINATION_AIRPORT_ID_KEY ("flight_destination_airport_id"),
    FLIGHT_DESTINATION_AIRPORT_CITY_KEY ("flight_destination_airport_city"),
    GUEST("guest"),
    LOGIN_STATUS_MESSAGE_KEY ("login_status_message"),
    LANGUAGE_KEY ("language"),
    LOCALISATION_ATTRIBUTE_NAME ("localisation"),
    MANAGE_EMPLOYEES ("manage_employees"),
    NEXT_PAGE ("next_page"),
    PREVIOUS_PAGE ("previous_page"),
    PAGE_KEY ("page"),
    SUCCESS_MESSAGE_KEY ("success_message"),
    SYSTEM_ROLE_ID_KEY ("system_role_id"),
    SYSTEM_ROLE_NAME_KEY ("system_role_name"),
    SUCCESS("success"),
    UNREGISTERED ("Unregistered"),
    USER ("user"),
    WHITE_SPACE (" "),
    WARNING_MESSAGE_KEY ("warning_message"),
    ZERO ("0");



    String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
