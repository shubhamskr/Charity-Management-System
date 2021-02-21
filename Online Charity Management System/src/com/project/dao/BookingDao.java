package com.project.dao;

import com.project.entity.BookingDetails;
import com.project.exception.DaoException;


public interface BookingDao {

	public void addBooking(BookingDetails booking) throws DaoException;
	
	
}
