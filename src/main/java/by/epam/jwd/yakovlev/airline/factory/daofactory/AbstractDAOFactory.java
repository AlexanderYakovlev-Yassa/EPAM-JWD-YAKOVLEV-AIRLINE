package by.epam.jwd.yakovlev.airline.factory.daofactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class AbstractDAOFactory<T> {

	public abstract T create(ResultSet resultSet) throws SQLException ;
}
