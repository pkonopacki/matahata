package com.zwort.matahata.core.sp.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.zwort.matahata.core.sp.request.AddPlanRequest;
import com.zwort.matahata.core.sp.response.AddPlanResponse;

@WebService(targetNamespace = "http://matahata.zwort.com/core/sp/ws/PlanManagement", name = "PlanManagement")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface PlanManagement {
	
	public AddPlanResponse addNewPlan(@WebParam AddPlanRequest request);

}
