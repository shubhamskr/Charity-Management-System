/**
 * 
 */
package com.project.dao;

import com.project.exception.DaoException;

public class DaoFactory {
	private static final String LOGIN_DAO 
		= "com.project.dao.jdbc.LoginDaoJdbcImpl";
	private static final String BOOKING_DAO 
		= "com.project.dao.jdbc.BookingDaoJdbcImpl";
	private static final String PAYMENT_LOT_DAO 
	= "com.project.dao.jdbc.PaymentDaoJdbcImpl";
	
	public static LoginDao getLoginDao() throws DaoException {
		try {
			return (LoginDao) Class.forName(LOGIN_DAO).newInstance();
		} catch (InstantiationException e) {
			throw new DaoException("unable to instantiate LoginDao", e);
		} catch (IllegalAccessException e) {
			throw new DaoException("unable to instantiate LoginDao", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("unable to instantiate LoginDao", e);
		}
	}
	
	public static BookingDao getBookingDao() throws DaoException {
		try {
			return (BookingDao) Class.forName(BOOKING_DAO).newInstance();
		} catch (InstantiationException e) {
			throw new DaoException("unable to instantiate BookingDao", e);
		} catch (IllegalAccessException e) {
			throw new DaoException("unable to instantiate BookingDao", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("unable to instantiate BookingDao", e);
		}
	}


	public static PaymentDao getPaymentDao() throws DaoException {
		try {
			return (PaymentDao) Class.forName(PAYMENT_LOT_DAO).newInstance();
		} catch (InstantiationException e) {
			throw new DaoException("unable to instantiate CharityLotDao", e);
		} catch (IllegalAccessException e) {
			throw new DaoException("unable to instantiate CharityLotDao", e);
		} catch (ClassNotFoundException e) {
			throw new DaoException("unable to instantiate CharityLotDao", e);
		}
	}

}
