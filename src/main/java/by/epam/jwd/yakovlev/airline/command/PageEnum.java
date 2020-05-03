package by.epam.jwd.yakovlev.airline.command;

public enum PageEnum {
    AIRCRAFTS ("/jsp/Aircrafts.jsp"),
    INDEX ("/jsp/Index.jsp"),
    LOGIN ("/jsp/Login.jsp"),
    REGISTRATION ("/jsp/Registration.jsp"),
    ERROR ("/jsp/ErrorPage.jsp"),
    REGISTRATION_SUCCESS ("/jsp/RegistrationSuccess.jsp"),
    EMPLOYEE ("/jsp/Employee.jsp"),
    CABINET ("/jsp/Cabinet.jsp"),
    AIRCRAFT_MANAGEMENT ("/jsp/AircraftManagement.jsp"),
    AIRCRAFT_MODELS_MANAGEMENT ("/jsp/AircraftModelsManagement.jsp"),
    AIRPORT_MANAGEMENT ("/jsp/AirportsManagement.jsp"),
    FLIGHTS_MANAGEMENT ("/jsp/FlightManagement.jsp"),
    FLIGHT_SCHEDULE ("/jsp/FlightSchedule.jsp"),
    SECURITY_ALERT_PAGE ("/jsp/SecurityAlertPage.jsp"),
    SELECT_CREW ("/jsp/SelectCrewPage.jsp"),
    UNRECOGNIZED_COMMAND_PAGE ("/jsp/UnrecognizedCommandPage.jsp");

    private String pageURL;

    PageEnum(String pageURL) {
        this.pageURL = pageURL;
    }

    public static String getPageURL(String pageName) {

        if (pageName == null) {
            return null;
        }

        String URL = null;

        for (PageEnum p : PageEnum.values()) {
            if (p.name().equals(pageName)) {
                URL = p.pageURL;
                break;
            }
        }

        return URL;
    }

    public String getPageURL() {
        return pageURL;
    }
}
