package com.zwort.matahata.ws.client;

public class MatahataClientConfig {

	private String user;

	private String password;

	private String url;

	private boolean ignoreCn;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isIgnoreCn() {
		return ignoreCn;
	}

	public boolean getIgnoreCnBig() {
		return Boolean.valueOf(ignoreCn);
	}

	public void setIgnoreCn(final boolean ignoreCn) {
		this.ignoreCn = ignoreCn;
	}

}
