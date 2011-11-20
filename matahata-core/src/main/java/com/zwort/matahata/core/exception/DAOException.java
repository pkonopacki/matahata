package com.zwort.matahata.core.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 2564549099383793375L;

	public DAOException() {
		super();
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DAOException(Throwable cause) {
		super(cause);
	}
	
}
