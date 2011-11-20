package com.zwort.matahata.core.sp.service;

import com.zwort.matahata.core.sp.dto.PlanDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public interface PlanManagementService {
	
	public Long addNewPlan(PlanDTO dto) throws ServiceProviderException;
	
	//public boolean extitPlan(Date startDate, Date endDate, String accountNumber);

}
