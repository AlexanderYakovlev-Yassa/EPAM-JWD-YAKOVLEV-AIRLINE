package by.epam.jwd.yakovlev.airline.command;

public enum SystemRoleEnum{
    UNREGISTERED (3),
    USER (2),
    DISPATCHER (1),
    ADMINISTRATOR (0);

    private int securityIndex;

    SystemRoleEnum(int securityIndex) {
        this.securityIndex = securityIndex;
    }

    public int getSecurityIndex() {
        return securityIndex;
    }
}
