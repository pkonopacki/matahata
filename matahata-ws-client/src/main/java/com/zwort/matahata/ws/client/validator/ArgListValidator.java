package com.zwort.matahata.ws.client.validator;


public class ArgListValidator {

	public static String validateArgList(String[] args) {
		StringBuffer usage = new StringBuffer();
		
		if (args.length == 0) {
			usage.append("Usage: KrapoParser <file>");
			return usage.toString();
		} 
		
		return usage.toString();
	}
}
