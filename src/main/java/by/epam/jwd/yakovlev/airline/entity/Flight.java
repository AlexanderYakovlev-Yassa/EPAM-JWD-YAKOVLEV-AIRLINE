package by.epam.jwd.yakovlev.airline.entity;

import java.util.Date;

public class Flight {

    private int flightID;
    private Date departureTime;
    private Date landingTime;
    private Aircraft aircraft;
    private Airport departureAirport;
    private Airport destinationAirport;

    public Flight() {
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(Date landingTime) {
        this.landingTime = landingTime;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport depertureAirport) {
        this.departureAirport = depertureAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (flightID != flight.flightID) return false;
        if (departureTime != null ? !departureTime.equals(flight.departureTime) : flight.departureTime != null)
            return false;
        if (landingTime != null ? !landingTime.equals(flight.landingTime) : flight.landingTime != null) return false;
        if (aircraft != null ? !aircraft.equals(flight.aircraft) : flight.aircraft != null) return false;
        if (departureAirport != null ? !departureAirport.equals(flight.departureAirport) : flight.departureAirport != null)
            return false;
        return destinationAirport != null ? destinationAirport.equals(flight.destinationAirport) : flight.destinationAirport == null;
    }

    @Override
    public int hashCode() {
        int result = flightID;
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        result = 31 * result + (landingTime != null ? landingTime.hashCode() : 0);
        result = 31 * result + (aircraft != null ? aircraft.hashCode() : 0);
        result = 31 * result + (departureAirport != null ? departureAirport.hashCode() : 0);
        result = 31 * result + (destinationAirport != null ? destinationAirport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Flight{");
        sb.append("flightID=").append(flightID);
        sb.append(", departureTime=").append(departureTime);
        sb.append(", landingTime=").append(landingTime);
        sb.append(", aircraft=").append(aircraft);
        sb.append(", depertureAirport=").append(departureAirport);
        sb.append(", destinationAirport=").append(destinationAirport);
        sb.append('}');
        return sb.toString();
    }
}
