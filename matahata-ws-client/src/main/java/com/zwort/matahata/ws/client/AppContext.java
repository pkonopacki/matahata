package com.zwort.matahata.ws.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {
	
	private ApplicationContext appCtx;
	
	private static AppContext _instance;
	
	private AppContext() {
		String[] contextPaths = new String[]{"applicationContext.xml"};
		this.appCtx = new ClassPathXmlApplicationContext(contextPaths);		
		
	}
	
	public ApplicationContext getApplicationContext() {
		return this.appCtx; 
	}
	
	public static AppContext getInstance() {
		
		if (_instance == null) {
			_instance = new AppContext();
		}
		return _instance;
	}

}
