/**
 * 
 */
package com.project.exception;

public class RentalApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -923589109323357767L;

	/**
	 * 
	 */
	public RentalApplicationException() {
	}

	/**
	 * @param message
	 */
	public RentalApplicationException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public RentalApplicationException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RentalApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "RentalApplicationException [getClass()=" + getClass()
				+ ", getMessage()=" + getMessage() + "]";
	}

	
}
