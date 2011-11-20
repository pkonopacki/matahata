package com.zwort.matahata.core.sp.adapter;

import zwort.com.matahata.services._1.AddPlanRequest;
import zwort.com.matahata.services._1.AddPlanResponse;

import com.zwort.matahata.core.sp.ServiceLocator;
import com.zwort.matahata.core.sp.binder.PlanRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;

public class PlanManagementAdapter extends BaseAdapter {
	
	public AddPlanResponse addNewPlan(AddPlanRequest request) {
		PlanRequestResponseBinder binder = new PlanRequestResponseBinder();
		AddPlanResponse response = new AddPlanResponse();
		
		try {
			binder.bindAddPlanResponseFromLong(ServiceLocator.getInstance().getPlanManagementService().addNewPlan(binder.bindPlanDtoFromAddPlanRequest(request)));
			
		} catch (Exception e) {
			logger.error("PlanManagementAdapter.addNewPlan failed: ", e);
			response = (AddPlanResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "PlanManagementAdapter.addNewPlan failed.");
		}
		
		return response;
	}

}
