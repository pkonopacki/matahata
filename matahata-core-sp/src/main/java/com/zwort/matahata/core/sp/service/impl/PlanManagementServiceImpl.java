package com.zwort.matahata.core.sp.service.impl;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.sp.binder.PlanManagementBinder;
import com.zwort.matahata.core.sp.dto.PlanDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.PlanManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;

public class PlanManagementServiceImpl extends AbstractManagementService implements PlanManagementService {
	
	private static final Log logger = LogFactory.getLog(PlanManagementServiceImpl.class);
	
	@Inject
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

}
