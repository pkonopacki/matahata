package com.zwort.matahata.cli.model;

public enum ItemType {
	
	TRANSFER(1),
	INCOME(2),
	EXPENSE(3);
	
	private int code;
	
	private ItemType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
}
