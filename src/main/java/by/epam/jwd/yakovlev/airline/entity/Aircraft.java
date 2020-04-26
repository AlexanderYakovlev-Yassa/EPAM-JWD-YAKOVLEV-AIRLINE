package by.epam.jwd.yakovlev.airline.entity;

import java.io.Serializable;

public class Aircraft implements Serializable {

	private static final long serialVersionUID = 1L;
	private int aircraftID;
    private String aircraftSideNumber;
    private AircraftModel aircraftModel;

    public Aircraft() {
    }    
    
    public Aircraft(int aircraftID, String aircraftSideNumber, AircraftModel aircraftModel) {
		this.aircraftID = aircraftID;
		this.aircraftSideNumber = aircraftSideNumber;
		this.aircraftModel = aircraftModel;
	}

	public int getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(int aircraftID) {
        this.aircraftID = aircraftID;
    }

    public String getAircraftSideNumber() {
        return aircraftSideNumber;
    }

    public void setAircraftSideNumber(String aircraftSideNumber) {
        this.aircraftSideNumber = aircraftSideNumber;
    }

    public AircraftModel getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(AircraftModel aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        if (aircraftID != aircraft.aircraftID) return false;
        if (!aircraftSideNumber.equals(aircraft.aircraftSideNumber)) return false;
        return aircraftModel.equals(aircraft.aircraftModel);
    }

    @Override
    public int hashCode() {
        int result = aircraftID;
        result = 31 * result + aircraftSideNumber.hashCode();
        result = 31 * result + aircraftModel.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Aircraft{");
        sb.append("aircraftID=").append(aircraftID);
        sb.append(", aircraftBordNumber='").append(aircraftSideNumber).append('\'');
        sb.append(", aircraftModel=").append(aircraftModel);
        sb.append('}');
        return sb.toString();
    }
}
