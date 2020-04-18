package by.epam.jwd.yakovlev.airline.entity;

import java.io.Serializable;

public class SystemRole implements Serializable {

    private int systemRoleID;
    private String systemRoleName;

    public SystemRole() {
    }

    public int getSystemRoleID() {
        return systemRoleID;
    }

    public void setSystemRoleID(int systemRoleID) {
        this.systemRoleID = systemRoleID;
    }

    public String getSystemRoleName() {
        return systemRoleName;
    }

    public void setSystemRoleName(String systemRoleName) {
        this.systemRoleName = systemRoleName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SystemRole that = (SystemRole) o;

        if (systemRoleID != that.systemRoleID) {
            return false;
        }

        return systemRoleName != null ? systemRoleName.equals(that.systemRoleName) : that.systemRoleName == null;
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int result = systemRoleID;

        result = prime * result + (systemRoleName != null ? systemRoleName.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "SystemRole{" +
                "systemRoleID=" + systemRoleID +
                ", systemRoleName='" + systemRoleName + '\'' +
                '}';
    }
}
