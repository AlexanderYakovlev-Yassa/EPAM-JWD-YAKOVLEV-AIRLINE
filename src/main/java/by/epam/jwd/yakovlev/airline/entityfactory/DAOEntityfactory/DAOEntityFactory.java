package by.epam.jwd.yakovlev.airline.entityfactory.DAOEntityfactory;

import by.epam.jwd.yakovlev.airline.exception.EntityFactoryException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public interface DAOEntityFactory {

    Optional<Object> make(ResultSet resultSet) throws SQLException;
    
}
