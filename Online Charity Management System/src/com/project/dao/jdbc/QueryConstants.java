/**
 * 
 */
package com.project.dao.jdbc;

public enum QueryConstants {
	ADD_USER("insert into reg_table " +
			"(email, first_name, last_name, password,admin,gender)" +
			"values(?, ?, ?, ?, ?, ?)"),
	ADD_BOOKING("insert into booking " +
			"(id, charity_name, email, booked_date," +
			"amnt, full_name,payment_id)" +
			"values (?,?,?,?,?,?,?)"),
	ADD_PAYMENT("insert into payment " +
			"(id, name, number, month," +
			"year,cvv)" +
			"values (?,?,?,?,?,?)"),
	CHECK_VALID_USER("SELECT * FROM reg_table " +
			" WHERE email=? and password=? and admin=?");

	
	private QueryConstants(String query){
		this.query = query;
	}
	String query;
	public String getQuery(){
		return query;
	}
}
