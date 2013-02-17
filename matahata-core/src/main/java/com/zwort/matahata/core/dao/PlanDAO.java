package com.zwort.matahata.core.dao;

import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.PlanItem;

import java.util.Date;

public interface PlanDAO extends EntityDAO<Plan> {
	
	public Plan getCurrentAccountPlan(Date date)throws DAOException;
	
	public boolean isPlanExist(Date startDate, Date endDate) throws DAOException;
	
	public PlanItem savePlanItem(PlanItem planItem);
	
}
