package by.epam.jwd.yakovlev.airline.entity;

public class AircraftModel {

    private int aircraftModelID;
    private String aircraftModelName;
    private int aircraftModelCapacity;

    public AircraftModel() {
    }

    public int getAircraftModelID() {
        return aircraftModelID;
    }

    public void setAircraftModelID(int aircraftModelID) {
        this.aircraftModelID = aircraftModelID;
    }

    public String getAircraftModelName() {
        return aircraftModelName;
    }

    public void setAircraftModelName(String aircraftModelName) {
        this.aircraftModelName = aircraftModelName;
    }

    public int getAircraftModelCapacity() {
        return aircraftModelCapacity;
    }

    public void setAircraftModelCapacity(int aircraftModelCapacity) {
        this.aircraftModelCapacity = aircraftModelCapacity;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AircraftModel aircraftModel = (AircraftModel) o;

        if (aircraftModelID != aircraftModel.aircraftModelID || aircraftModelCapacity != aircraftModel.aircraftModelCapacity) {
            return false;
        }

        return aircraftModelName != null ? aircraftModelName.equals(aircraftModel.aircraftModelName) : aircraftModel.aircraftModelName == null;
    }

    @Override
    public int hashCode() {

        int prime = 31;
        int result = aircraftModelID;

        result = prime * result + (aircraftModelName != null ? aircraftModelName.hashCode() : 0);
        result = prime * result + aircraftModelCapacity;

        return result;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftModelID=" + aircraftModelID +
                ", aircraftModelName='" + aircraftModelName + '\'' +
                ", aircraftModelCapacity=" + aircraftModelCapacity +
                '}';
    }
}
