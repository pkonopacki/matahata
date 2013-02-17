package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Plan;

import java.util.Date;

public interface PlanService extends EntityService<Plan> {
	
	Plan getPlanByDate(Date date) throws ServiceException;
	
}
