package com.zwort.matahata.core.sp.ws;

import com.zwort.matahata.core.sp.request.AddTransferRequest;
import com.zwort.matahata.core.sp.response.AddTransferResponse;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://matahata.zwort.com/core/sp/ws/TransferManagement", name = "TransferManagement")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TransferManagement {
	
	public AddTransferResponse addNewTransfer(@WebParam AddTransferRequest request);

}
