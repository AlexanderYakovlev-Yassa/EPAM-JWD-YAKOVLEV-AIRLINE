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

import com.mysql.jdbc.Driver;
import org.apache.log4j.Logger;

public enum ConnectionsPool {

    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(ConnectionsPool.class);
    private static Properties AIRLINE_DB_PROPERTIES = new Properties();

    private static final int MAX_POOL_SIZE = 32;
    private static String AIRLINE_DB_PROPERTY_FILE = "AirlineDB.properties";
    private static String URL;

    private BlockingQueue<ProxyConnection> availableConnections = new ArrayBlockingQueue<>(MAX_POOL_SIZE);
    private List<ProxyConnection> usedConnections = new ArrayList<>();

    private boolean isInitialised = false;

    public void initializePool() throws AirlineDataBaseConnectionException {

        if (isInitialised) {
            return;
        }

        initializeProperties();

        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            LOGGER.warn("Can't initialise the connection pool", e);
            throw new AirlineDataBaseConnectionException("Can't initialise the connection pool", e);
        }

        for (int i = 0; i < MAX_POOL_SIZE; i++) {

            addNewConnectionIntoPool();
        }

        if (availableConnections.size() > 0) {
            isInitialised = true;
            LOGGER.debug("Connection pool has been initialised");
        } else {
            LOGGER.debug("Connection pool fail initialise");
        }
    }

    public Connection getConnection() throws AirlineDataBaseConnectionException {

        if (!isInitialised) {
            LOGGER.debug("Can't get connection because the pool of connections was not initialised.");
            throw new AirlineDataBaseConnectionException("Pool of connections is not initialised.");
        }

        ProxyConnection connection = null;
        try {
            connection = availableConnections.take();
            if (connection != null) {
                usedConnections.add(connection);
            }
        } catch (InterruptedException e) {
            throw new AirlineDataBaseConnectionException("Fail to get connection", e);
        }

        return connection;
    }

    public boolean releaseConnection(ProxyConnection connection) {

        boolean connectionReleased;

        if (connectionReleased = usedConnections.remove(connection)) {
            availableConnections.add(connection);
        }

        return connectionReleased;
    }

    public void close() {

            for (Connection c : availableConnections) {
                ((ProxyConnection) c).closePoolConnection();
            }

            LOGGER.debug("Connection pool was been closed");
    }

    private void addNewConnectionIntoPool() {

        try {
            ProxyConnection connection = new ProxyConnection(DriverManager.getConnection(URL, AIRLINE_DB_PROPERTIES));
            availableConnections.add(connection);
        } catch (SQLException e) {
            LOGGER.warn("Can't connect with the database during add connection to the pool of connections", e);
        }
    }

    private void initializeProperties() {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(AIRLINE_DB_PROPERTY_FILE);
        LOGGER.debug("property file was red");

        try {
            AIRLINE_DB_PROPERTIES.load(inputStream);
        } catch (IOException e) {
            LOGGER.debug("Can't read properties", e);
        }

        URL = AIRLINE_DB_PROPERTIES.getProperty("url");
    }
}
