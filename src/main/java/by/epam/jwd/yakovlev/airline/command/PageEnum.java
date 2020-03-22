package by.epam.jwd.yakovlev.airline.command;

public enum PageEnum {
    INDEX ("/jsp/Index.jsp"),
    LOGIN ("/jsp/Login.jsp"),
    ERROR ("/jsp/error.jsp");

    private String page;

    PageEnum(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }
}
