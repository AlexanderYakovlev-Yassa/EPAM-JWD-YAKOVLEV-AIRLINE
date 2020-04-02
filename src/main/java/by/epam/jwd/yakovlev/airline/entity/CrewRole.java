package by.epam.jwd.yakovlev.airline.entity;

public class CrewRole {

    private int crewRoleID;
    private String crewRoleName;

    public CrewRole() {
    }

    public int getCrewRoleID() {
        return crewRoleID;
    }

    public void setCrewRoleID(int crewRoleID) {
        this.crewRoleID = crewRoleID;
    }

    public String getCrewRoleName() {
        return crewRoleName;
    }

    public void setCrewRoleName(String crewRoleName) {
        this.crewRoleName = crewRoleName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CrewRole crewRole = (CrewRole) o;

        if (crewRoleID != crewRole.crewRoleID) {
            return false;
        }

        return crewRoleName != null ? crewRoleName.equals(crewRole.crewRoleName) : crewRole.crewRoleName == null;
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int result = crewRoleID;

        result = prime * result + (crewRoleName != null ? crewRoleName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CrewRole{" +
                "crewRoleID=" + crewRoleID +
                ", crewRoleName='" + crewRoleName + '\'' +
                '}';
    }
}
