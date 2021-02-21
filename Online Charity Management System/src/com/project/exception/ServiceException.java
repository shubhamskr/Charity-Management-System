/**
 * 
 */
package com.project.exception;

public class ServiceException extends RentalApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2949347790957527320L;

	/**
	 * 
	 */
	public ServiceException() {
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
