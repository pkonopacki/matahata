package com.zwort.matahata.core.sp.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zwort.com.matahata.services._1.AddTransferRequestList;
import zwort.com.matahata.services._1.AddTransferResponseList;

import com.zwort.matahata.core.sp.ServiceLocator;
import com.zwort.matahata.core.sp.binder.TransferRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;

public class TransferManagementAdapter {

	private static Log logger = LogFactory.getLog(TransferManagementAdapter.class);
	
	public AddTransferResponseList addNewTransfer(AddTransferRequestList addNewTransfer) {
		TransferRequestResponseBinder binder = new TransferRequestResponseBinder();
		AddTransferResponseList response = new AddTransferResponseList();
		
		try {
			response = binder.bindResponsesList(ServiceLocator.getInstance().getTransferManagementService().addNewTransfer(binder.bindTransferDtoListFromAddTransferRequestList(addNewTransfer)));
		
		} catch (Exception e) {
			logger.error("TransferManagementAdapter.addNewTransfer failed: ", e);
			response = (AddTransferResponseList) ErrorPropertiesUtils.setErrorInfo(response, e, "TransferManagementAdapter.addNewTransfer failed: " + e.getMessage());
		}
		
		return response;
	}

}
