package by.epam.jwd.yakovlev.airline.factory.daofactory.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.epam.jwd.yakovlev.airline.entity.Crew;
import by.epam.jwd.yakovlev.airline.entity.Employee;
import by.epam.jwd.yakovlev.airline.exception.DaoFactoryException;
import by.epam.jwd.yakovlev.airline.factory.daofactory.AbstractDAOFactory;
import by.epam.jwd.yakovlev.airline.util.StringConstant;

public class DAOCrewFactory extends AbstractDAOFactory<Crew> {

	@Override
	public Crew create(ResultSet resultSet) throws DaoFactoryException, SQLException {

		checkResultSetForNull(resultSet);

		Crew crew = new Crew();
		crew.setCrewMembersList(new ArrayList<Employee>());

		resultSet.beforeFirst();

		while (resultSet.next()) {

			if (crew.getFlightID() == 0) {
				crew.setFlightID(resultSet.getInt(StringConstant.FLIGHT_ID_KEY.getValue()));
			}

			crew.getCrewMembersList().add(createEmployee(resultSet));
		}

		return crew;
	}
}
