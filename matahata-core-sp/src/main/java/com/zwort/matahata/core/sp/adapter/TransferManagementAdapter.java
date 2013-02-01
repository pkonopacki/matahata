package com.zwort.matahata.core.sp.adapter;

import com.zwort.matahata.core.sp.binder.TransferRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;
import com.zwort.matahata.core.sp.service.TransferManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.AddTransferRequestList;
import zwort.com.matahata.services._1.AddTransferResponseList;

@Component
public class TransferManagementAdapter {

	@Autowired
    private TransferManagementService transferManagementService;

    private static Log logger = LogFactory.getLog(TransferManagementAdapter.class);
	
	public AddTransferResponseList addNewTransfer(AddTransferRequestList addNewTransfer) {
		TransferRequestResponseBinder binder = new TransferRequestResponseBinder();
		AddTransferResponseList response = new AddTransferResponseList();
		
		try {
			response = binder.bindResponsesList(transferManagementService.addNewTransfer(binder.bindTransferDtoListFromAddTransferRequestList(addNewTransfer)));

		} catch (Exception e) {
			logger.error("TransferManagementAdapter.addNewTransfer failed: ", e);
			response = (AddTransferResponseList) ErrorPropertiesUtils.setErrorInfo(response, e, "TransferManagementAdapter.addNewTransfer failed: " + e.getMessage());
		}
		
		return response;
	}

}
