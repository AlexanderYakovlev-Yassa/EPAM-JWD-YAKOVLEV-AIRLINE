package by.epam.jwd.yakovlev.airline.dbconnection;

import java.sql.Connection;

public interface ConnectionsPool {

    Connection getConnection();

    boolean releaseConnection(Connection connection);

    String getUrl();

    String getUser();

    String getPassword();
}
