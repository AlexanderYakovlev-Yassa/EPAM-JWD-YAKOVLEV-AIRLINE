package by.epam.jwd.yakovlev.airline.entity;

public class Airport {

    private int airportID;
    private String airportCity;

    public Airport() {
    }
    
    

    public Airport(int airportID, String airportCity) {
		this.airportID = airportID;
		this.airportCity = airportCity;
	}



	public int getAirportID() {
        return airportID;
    }

    public void setAirportID(int airportID) {
        this.airportID = airportID;
    }

    public String getAirportCity() {
        return airportCity;
    }

    public void setAirportCity(String airportCity) {
        this.airportCity = airportCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (airportID != airport.airportID) return false;
        return airportCity != null ? airportCity.equals(airport.airportCity) : airport.airportCity == null;
    }

    @Override
    public int hashCode() {
        int result = airportID;
        result = 31 * result + (airportCity != null ? airportCity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Airport{");
        sb.append("airportID=").append(airportID);
        sb.append(", airportCity='").append(airportCity).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
