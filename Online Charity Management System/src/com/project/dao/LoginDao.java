package com.project.dao;

import com.project.entity.User;
import com.project.exception.DaoException;

public interface LoginDao {

	public boolean checkValidUser(User user) throws DaoException;

	public void registerUser(User user) throws DaoException;
	
	
}