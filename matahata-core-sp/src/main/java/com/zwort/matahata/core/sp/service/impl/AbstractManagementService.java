package com.zwort.matahata.core.sp.service.impl;

import com.zwort.matahata.core.facade.Facade;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractManagementService {
	
	@Autowired
    protected Facade facade;

}
