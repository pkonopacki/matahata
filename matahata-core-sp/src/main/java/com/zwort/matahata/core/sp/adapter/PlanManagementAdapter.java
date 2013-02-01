package com.zwort.matahata.core.sp.adapter;

import com.zwort.matahata.core.sp.binder.PlanRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;
import com.zwort.matahata.core.sp.service.PlanManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.AddPlanRequest;
import zwort.com.matahata.services._1.AddPlanResponse;

@Component
public class PlanManagementAdapter extends BaseAdapter {
	
	@Autowired
    private PlanManagementService planManagementService;

    public AddPlanResponse addNewPlan(AddPlanRequest request) {
		PlanRequestResponseBinder binder = new PlanRequestResponseBinder();
		AddPlanResponse response = new AddPlanResponse();
		
		try {
			binder.bindAddPlanResponseFromLong(planManagementService.addNewPlan(binder.bindPlanDtoFromAddPlanRequest(request)));
			
		} catch (Exception e) {
			logger.error("PlanManagementAdapter.addNewPlan failed: ", e);
			response = (AddPlanResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "PlanManagementAdapter.addNewPlan failed.");
		}
		
		return response;
	}

}
