package com.zwort.matahata.core.sp.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.zwort.matahata.core.sp.request.AddIncomeRequest;
import com.zwort.matahata.core.sp.response.AddIncomeResponse;

@WebService(targetNamespace = "http://matahata.zwort.com/core/sp/ws/TransferManagement", name = "TransferManagement")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface IncomeManagement {
	
	public AddIncomeResponse addNewIncome(@WebParam AddIncomeRequest request);

}
