package com.zwort.matahata.core.service.locator;

import org.springframework.context.ApplicationContext;

public class AppContext {
	
	private static ApplicationContext ctx;
	
	public static void setApplicationContext(ApplicationContext applicationCtx) {
		ctx = applicationCtx;
	}
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

}
