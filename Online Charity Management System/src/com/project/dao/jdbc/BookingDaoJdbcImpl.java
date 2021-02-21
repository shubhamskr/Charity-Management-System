package com.project.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import com.project.dao.BookingDao;
import com.project.entity.BookingDetails;
import com.project.exception.DaoException;


public class BookingDaoJdbcImpl extends BaseDao implements BookingDao {

	public BookingDaoJdbcImpl() throws DaoException {
		super();
	}

	@Override
	public void addBooking(BookingDetails booking) throws DaoException {
		Connection con = getConnection();
		
		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(QueryConstants.ADD_BOOKING.getQuery());
			String bookingId = UUID.randomUUID().toString();
			psmt.setString(1, bookingId);
			psmt.setString(2, booking.getCharity());
			psmt.setString(3, booking.getEmail());
			psmt.setString(4, booking.getBookedDate());
			psmt.setString(5, booking.getAMOUNT());
			psmt.setString(6, booking.getFULLNAME());
			psmt.setString(7, booking.getPAYMENTID());
			psmt.executeUpdate();
		} catch (SQLException e) {
//			System.out.println("Exception"+e);
			throw new DaoException("Not Available", e);
		} finally {
			closeStatement(psmt);
			closeConnection(con);
		}

	}

}
