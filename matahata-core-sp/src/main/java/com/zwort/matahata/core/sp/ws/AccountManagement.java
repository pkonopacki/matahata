package com.zwort.matahata.core.sp.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.zwort.matahata.core.sp.request.AddAccountRequest;
import com.zwort.matahata.core.sp.response.AddAccountResponse;

@WebService(targetNamespace = "http://matahata.zwort.com/core/sp/ws/AccountManagement", name = "AccountManagement")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public interface AccountManagement {

	//TODO: Play around with annotations
	
	@WebMethod
	public AddAccountResponse addAccount (
		@WebParam AddAccountRequest request
	);

}
