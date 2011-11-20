package com.zwort.matahata.core.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -2120392555443516351L;

	public ServiceException() {
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
