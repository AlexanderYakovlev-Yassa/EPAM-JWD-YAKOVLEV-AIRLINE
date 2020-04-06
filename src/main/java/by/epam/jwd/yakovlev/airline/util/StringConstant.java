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
    COMMAND_KEY ("command"),
    CURRENT_SESSION_USER_KEY ("current_session_user"),
    CURRENT_SESSION_ROLE_KEY ("current_session_role"),
    CURRENT_PAGE ("current_page"),
    CREW_ROLE_KEY ("crew_role"),
    CREW_ROLE_ID_KEY ("crew_role_id"),
    CREW_ROLE_NAME_KEY ("crew_role_name"),
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
    GUEST("guest"),
    LOGIN_STATUS_MESSAGE_KEY ("login_status_message"),
    LANGUAGE_KEY ("language"),
    LOCALISATION_ATTRIBUTE_NAME ("localisation"),
    NEXT_PAGE ("next_page"),
    PREVIOUS_PAGE ("previous_page"),
    PAGE_KEY ("page"),
    SYSTEM_ROLE_ID_KEY ("system_role_id"),
    SYSTEM_ROLE_NAME_KEY ("system_role_name"),
    SUCCESS("success"),
    UNREGISTERED ("Unregistered"),
    USER ("user"),
    WHITE_SPACE (" "),
    ZERO ("0");



    String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}