package by.epam.jwd.yakovlev.airline.entity;

import java.io.Serializable;

public class Employee implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String nickname;
    private SystemRole systemRole;
    private CrewRole crewRole;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String secondName) {
        this.lastName = secondName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public SystemRole getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }

    public CrewRole getCrewRole() {
        return crewRole;
    }

    public void setCrewRole(CrewRole crewRole) {
        this.crewRole = crewRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (nickname != null ? !nickname.equals(employee.nickname) : employee.nickname != null) return false;
        if (systemRole != null ? !systemRole.equals(employee.systemRole) : employee.systemRole != null) return false;
        return crewRole != null ? crewRole.equals(employee.crewRole) : employee.crewRole == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (systemRole != null ? systemRole.hashCode() : 0);
        result = 31 * result + (crewRole != null ? crewRole.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", nickname='").append(nickname).append('\'');
        sb.append(", systemRole=").append(systemRole);
        sb.append(", crewRole=").append(crewRole);
        sb.append('}');
        return sb.toString();
    }
}
