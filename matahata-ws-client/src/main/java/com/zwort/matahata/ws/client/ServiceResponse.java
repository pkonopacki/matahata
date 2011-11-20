package com.zwort.matahata.ws.client;

public class ServiceResponse {
	
	//TODO: Elaborate a bit
	private int operationCode;
	
	private Object container;

	public int getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(int operationCode) {
		this.operationCode = operationCode;
	}

	public Object getContainer() {
		return container;
	}

	public void setContainer(Object container) {
		this.container = container;
	}
	
}
