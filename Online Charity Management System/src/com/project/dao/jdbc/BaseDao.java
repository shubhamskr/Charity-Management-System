/**
 * 
 */
package com.project.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.exception.DaoException;

public class BaseDao {
	private static final String DRIVER = DaoResource.getString("DRIVER");

	private static final String URL = DaoResource.getString("URL");

	private static final String USER_NAME = DaoResource.getString("USER");

	private static final String PASSWORD = DaoResource.getString("PWD");

	public BaseDao() throws DaoException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new DaoException("unable to load driver", e);
		}
	}

	public Connection getConnection() throws DaoException {
		try {
			return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			throw new DaoException("unable to get con", e);
		}
	}

	public void closeConnection(Connection connection) throws DaoException {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new DaoException("unable to release con", e);
			}
		}
	}

	public void closeStatement(PreparedStatement statement) throws DaoException {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new DaoException("unable to release stmt", e);
			}
		}
	}

	public void closeResultSet(ResultSet rs) throws DaoException {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DaoException("unable to release rs", e);
			}
		}
	}
}
