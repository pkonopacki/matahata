package com.zwort.matahata.core.sp.exception;

public class ServiceProviderException extends Exception {

	private static final long serialVersionUID = 1L;


	public ServiceProviderException() {
		
	}
	
	public ServiceProviderException(String message) {
		super(message);
	}
	
	public ServiceProviderException(Throwable cause) {
		super(cause);
	}
	
	public ServiceProviderException(String message, Throwable cause) {
		super(message, cause);
	}

}
