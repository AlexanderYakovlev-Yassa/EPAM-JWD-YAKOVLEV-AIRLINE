package by.epam.jwd.yakovlev.airline.entity;

import java.util.List;

public class Crew {

    private int crewID;
    private List<Employee> crewMembersList;
    private Flight flight;

    public Crew() {
    }

    public int getCrewID() {
        return crewID;
    }

    public void setCrewID(int crewID) {
        this.crewID = crewID;
    }

    public List<Employee> getCrewMembersList() {
        return crewMembersList;
    }

    public void setCrewMembersList(List<Employee> crewMembersList) {
        this.crewMembersList = crewMembersList;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Crew crew = (Crew) o;

        if (crewID != crew.crewID) return false;
        if (crewMembersList != null ? !crewMembersList.equals(crew.crewMembersList) : crew.crewMembersList != null)
            return false;
        return flight != null ? flight.equals(crew.flight) : crew.flight == null;
    }

    @Override
    public int hashCode() {
        int result = crewID;
        result = 31 * result + (crewMembersList != null ? crewMembersList.hashCode() : 0);
        result = 31 * result + (flight != null ? flight.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Crew{");
        sb.append("crewID=").append(crewID);
        sb.append(", crewMembersList=").append(crewMembersList);
        sb.append(", flight=").append(flight);
        sb.append('}');
        return sb.toString();
    }
}
