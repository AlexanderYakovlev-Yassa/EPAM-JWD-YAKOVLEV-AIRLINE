package by.epam.jwd.yakovlev.airline.pool;

import by.epam.jwd.yakovlev.airline.exception.AirlineDataBaseConnectionException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public enum ConnectionsPool {

    INSTANCE;

    private static final Logger logger = LogManager.getLogger(ConnectionsPool.class);
    private static Properties AIRLINE_DB_PROPERTIES = new Properties();

    private static final int MAX_POOL_SIZE = 32;
    private static String AIRLINE_DB_PROPERTY_FILE = "AirlineDB.properties";
    private static String URL;

    private BlockingQueue<ProxyConnection> availableConnections = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
    private List<ProxyConnection> usedConnections = new ArrayList<>();

    private boolean isInitialised = false;

    public void initializePool() {

        initializeProperties();

        for (int i = 0; i < MAX_POOL_SIZE; i++) {

            addNewConnectionIntoPool();
        }

        isInitialised = availableConnections.size() > 0;
    }

    private void initializeProperties() {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(AIRLINE_DB_PROPERTY_FILE);
        logger.debug("property file was red");
        try {
            AIRLINE_DB_PROPERTIES.load(inputStream);
        } catch (IOException e) {
            logger.debug("Can't initialise data base. " + e.getMessage());
        }

        URL = AIRLINE_DB_PROPERTIES.getProperty("url");
    }

    public Connection getConnection() throws AirlineDataBaseConnectionException {

        if (!isInitialised) {
            logger.debug("Pool of connections is not initialised.");
            throw new AirlineDataBaseConnectionException("Pool of connections is not initialised.");
        }

        ProxyConnection connection = null;
        try {
            connection = availableConnections.take();
            if (connection != null) {
                usedConnections.add(connection);
            }
        } catch (InterruptedException e) {
            throw new AirlineDataBaseConnectionException("Fail to get connection.");
        }

        return connection;
    }

    public boolean releaseConnection(ProxyConnection connection) {

        boolean connectionReleased = false;

        if (connectionReleased = usedConnections.remove(connection)) {
            availableConnections.add(connection);
        }

        return connectionReleased;
    }

    public void closePool() {

            for (Connection c : availableConnections) {
                ((ProxyConnection) c).closePoolConnection();
            }
    }

    private void addNewConnectionIntoPool() {

        try {
            ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(URL, AIRLINE_DB_PROPERTIES));
            availableConnections.add(connection);
        } catch (SQLException e) {
            logger.warn("Can't connect with data base. " + e.getMessage());
        }
    }
}
