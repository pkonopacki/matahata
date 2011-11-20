package com.zwort.matahata.core.sp.service.impl;

import com.zwort.matahata.core.facade.Facade;

public abstract class AbstractManagementService {
	
	protected Facade facade;

	public void setFacade(Facade facade) {
		this.facade = facade;
	}

}
