package com.zwort.matahata.core.sp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.sp.binder.PlanManagementBinder;
import com.zwort.matahata.core.sp.dto.PlanDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.PlanManagementService;

public class PlanManagementServiceImpl extends AbstractManagementService implements PlanManagementService {
	
	private static final Log logger = LogFactory.getLog(PlanManagementServiceImpl.class);
	
	private PlanManagementBinder binder;

	@Override
	public Long addNewPlan(PlanDTO dto) throws ServiceProviderException {

		try {
			return facade.savePlan(binder.bindPlanWithPlanDto(dto)).getId();
			
		} catch (ServiceException se) {
			logger.error("PlanManagementServiceImpl.addNewPlan failed: ", se);
			throw new ServiceProviderException("PlanManagementServiceImpl.addNewPlan failed: ", se);
		}
			
		
	}

//	@Override
//	public boolean extstPlan(Date startDate, Date endDate, String accountNumber) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	//Spring setters
	
	public void setBinder(PlanManagementBinder binder) {
		this.binder = binder;
	}

}
