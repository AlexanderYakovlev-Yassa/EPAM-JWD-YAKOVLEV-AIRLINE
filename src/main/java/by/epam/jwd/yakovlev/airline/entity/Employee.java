package by.epam.jwd.yakovlev.airline.entity;

public class Employee {

    int id;
    String firstName;
    String secondName;
    String nicName;
    int systemRole;
    int crewRole;

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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNicName() {
        return nicName;
    }

    public void setNicName(String nicName) {
        this.nicName = nicName;
    }

    public int getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(int systemRole) {
        this.systemRole = systemRole;
    }

    public int getCrewRole() {
        return crewRole;
    }

    public void setCrewRole(int crewRole) {
        this.crewRole = crewRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (systemRole != employee.systemRole) return false;
        if (crewRole != employee.crewRole) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (secondName != null ? !secondName.equals(employee.secondName) : employee.secondName != null) return false;
        return nicName != null ? nicName.equals(employee.nicName) : employee.nicName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (nicName != null ? nicName.hashCode() : 0);
        result = 31 * result + systemRole;
        result = 31 * result + crewRole;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", nicName='").append(nicName).append('\'');
        sb.append(", systemRole=").append(systemRole);
        sb.append(", crewRole=").append(crewRole);
        sb.append('}');
        return sb.toString();
    }
}
