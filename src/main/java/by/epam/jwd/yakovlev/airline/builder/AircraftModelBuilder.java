package by.epam.jwd.yakovlev.airline.builder;

import by.epam.jwd.yakovlev.airline.entity.AircraftModel;
import by.epam.jwd.yakovlev.airline.exception.BuilderException;
import by.epam.jwd.yakovlev.airline.util.StringConstant;
import org.apache.log4j.Logger;

import java.util.Optional;
import java.util.Properties;

public enum  AircraftModelBuilder {
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(AircraftModelBuilder.class);

    public AircraftModel build(Properties aircraftModelProperties) throws BuilderException {

        if (aircraftModelProperties == null) {
            LOGGER.warn("There are no properties to build an aircraft model.");
            throw new BuilderException("There are no properties to build an aircraft model.");
        }

        String aircraftModelIDString = aircraftModelProperties.getProperty(
                StringConstant.AIRCRAFT_MODEL_ID_KEY.getValue());
        String aircraftModelName = aircraftModelProperties.getProperty(
                StringConstant.AIRCRAFT_MODEL_NAME_KEY.getValue());
        String aircraftModelCapacityString = aircraftModelProperties.getProperty(
                StringConstant.AIRCRAFT_MODEL_CAPACITY_KEY.getValue());

        int aircraftModelID;
        int aircraftModelCapacity;

        try {
            aircraftModelID = Integer.parseInt(aircraftModelIDString);
        } catch (NumberFormatException e) {
            LOGGER.warn("Invalid aircraft model ID. " + aircraftModelIDString);
            throw new BuilderException("Invalid aircraft model ID.", e);
        }

        try {
            aircraftModelCapacity = Integer.parseInt(aircraftModelCapacityString);
        } catch (NumberFormatException e) {
            LOGGER.warn("Invalid aircraft model capacity. " + aircraftModelCapacityString);
            throw new BuilderException("Invalid aircraft model capacity.", e);
        }

        AircraftModel aircraftModel = new AircraftModel();

        aircraftModel.setAircraftModelID(aircraftModelID);
        aircraftModel.setAircraftModelCapacity(aircraftModelCapacity);
        aircraftModel.setAircraftModelName(aircraftModelName);

        return aircraftModel;
    }
}