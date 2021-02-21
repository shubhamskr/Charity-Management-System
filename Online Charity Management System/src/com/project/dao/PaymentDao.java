package com.project.dao;

import com.project.entity.PaymentDetails;
import com.project.exception.DaoException;

public interface PaymentDao {

	public void addPayment(PaymentDetails paymentDetails) throws DaoException;
	
	
}
