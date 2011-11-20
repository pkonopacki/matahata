package com.zwort.matahata.core.service;

import java.util.Date;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Plan;

public interface PlanService extends EntityService<Plan> {
	
	Plan getPlanByDate(Date date) throws ServiceException;
	
}
