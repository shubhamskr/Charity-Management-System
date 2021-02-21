/**
 * 
 */
package com.project.exception;

public class DaoException extends RentalApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1399249599842545745L;

	/**
	 * 
	 */
	public DaoException() {
	}

	/**
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
