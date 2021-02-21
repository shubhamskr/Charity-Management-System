/**
 * 
 */
package com.project.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.dao.LoginDao;
import com.project.entity.User;
import com.project.exception.DaoException;


public class LoginDaoJdbcImpl extends BaseDao implements LoginDao {

	public LoginDaoJdbcImpl() throws DaoException {
		super();
	}

	@Override
	public boolean checkValidUser(User user) throws DaoException {
		Connection con = getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = con.prepareStatement(QueryConstants.CHECK_VALID_USER.getQuery());
			psmt.setString(1, user.getEmail());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getAdmin());
			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new DaoException("unable to check user " + user.getEmail(), e);
		} finally {
			closeStatement(psmt);
			closeConnection(con);
			closeResultSet(rs);
		}
		return false;
	}

	@Override
	public void registerUser(User user) throws DaoException {
		Connection con = getConnection();
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(QueryConstants.ADD_USER.getQuery());
			psmt.setString(1, user.getEmail());
			psmt.setString(2, user.getFirstName());
			psmt.setString(3, user.getLastName());
			psmt.setString(4, user.getPassword());
			psmt.setString(5, user.getAdmin());
			psmt.setString(6, user.getGender());
			psmt.executeUpdate();
		} catch (Exception e) {
//			System.out.println(e);
			throw new DaoException("This email is taken choose another Email:: " + user.getEmail(), e);
		} finally {
			closeStatement(psmt);
			closeConnection(con);
		}

	}

}
