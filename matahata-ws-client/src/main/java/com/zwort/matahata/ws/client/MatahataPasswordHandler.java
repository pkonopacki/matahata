package com.zwort.matahata.ws.client;

import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

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
