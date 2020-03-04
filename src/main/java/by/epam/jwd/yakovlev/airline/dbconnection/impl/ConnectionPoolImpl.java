package by.epam.jwd.yakovlev.airline.dbconnection.impl;

import by.epam.jwd.yakovlev.airline.dbconnection.ConnectionsPool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionPoolImpl implements ConnectionsPool {

    private static final String URL = "jdbc:mysql://localhost:3310/airline";
    private static final String AUTO_RECONNECT = "true";
    private static final String CHARACTER_ENCODING = "UTF-8";
    private static final String USE_UNICODE = "true";
    private static final int MIN_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 32;

    private String user;
    private String password;
    private Connection connection;
    private BlockingDeque availableConnections;
    private List<Connection> usedConnections = new ArrayList<>();
    private AtomicBoolean isInitialised = new AtomicBoolean(false);



    @Override
    public Connection getConnection() {
        return null;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        return false;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    public AtomicBoolean isInitialised() {
        return isInitialised;
    }

    private void initializePool(){

        //availableConnections = new ArrayBlockingQueue<>(MAX_POOL_SIZE);

        if (!isInitialised.get()) {

            for (int i = 0; i < MIN_POOL_SIZE; i++) {


            }
        }
    }
}
