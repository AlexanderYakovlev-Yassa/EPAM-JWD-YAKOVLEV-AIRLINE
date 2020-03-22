package by.epam.jwd.yakovlev.airline.command;

public enum PageEnum {
    INDEX ("/jsp/Index.jsp"),
    LOGIN ("/jsp/Login.jsp"),
    REGISTRATION ("/jsp/Registration.jsp"),
    ERROR ("/jsp/error.jsp"),
    REGISTRATION_SUCCESS ("/jsp/RegistrationSuccess.jsp");

    private String page;

    PageEnum(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
