package com.zwort.matahata.ws.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class MatahataPasswordHandler {
	
	private String password;

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		final WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		pc.setPassword(password);
	}
 
}
