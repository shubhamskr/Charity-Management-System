package com.project.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.project.dao.PaymentDao;
import com.project.entity.PaymentDetails;
import com.project.exception.DaoException;


public class PaymentDaoJdbcImpl extends BaseDao implements PaymentDao {

	public PaymentDaoJdbcImpl() throws DaoException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addPayment(PaymentDetails paymentDetails) throws DaoException {
		Connection con = getConnection();

		PreparedStatement psmt = null;
		try {
			psmt = con.prepareStatement(QueryConstants.ADD_PAYMENT.getQuery());
			psmt.setString(1, paymentDetails.getPAYMENTID());
			psmt.setString(2, paymentDetails.getNAME());
			psmt.setString(3, paymentDetails.getNUMBER());
			psmt.setString(4, paymentDetails.getMONTH());
			psmt.setString(5, paymentDetails.getYEAR());
			psmt.setString(6, paymentDetails.getCVV());
			psmt.executeUpdate();
		} catch (SQLException e) {
//			System.out.println(e);
			throw new DaoException("Incorrect Details...!!!", e);
		} finally {
			closeStatement(psmt);
			closeConnection(con);
		}

	}

}