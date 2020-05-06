package by.epam.jwd.yakovlev.airline.entity;

import java.util.List;

public class Crew {

	private int flightID;
    private List<Employee> crewMembersList;

    public Crew() {
    }

	public int getFlightID() {
		return flightID;
	}

	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}

	public List<Employee> getCrewMembersList() {
		return crewMembersList;
	}

	public void setCrewMembersList(List<Employee> crewMembersList) {
		this.crewMembersList = crewMembersList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crewMembersList == null) ? 0 : crewMembersList.hashCode());
		result = prime * result + flightID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Crew other = (Crew) obj;
		if (crewMembersList == null) {
			if (other.crewMembersList != null)
				return false;
		} else if (!crewMembersList.equals(other.crewMembersList))
			return false;
		if (flightID != other.flightID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Crew [flightID=" + flightID + ", crewMembersList=" + crewMembersList + "]";
	}
}
