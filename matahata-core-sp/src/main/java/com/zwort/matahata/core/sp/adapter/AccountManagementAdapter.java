package com.zwort.matahata.core.sp.adapter;

import com.zwort.matahata.core.sp.ServiceLocator;
import com.zwort.matahata.core.sp.binder.AccountManagementBinder;
import com.zwort.matahata.core.sp.request.AddAccountRequest;
import com.zwort.matahata.core.sp.response.AddAccountResponse;

public class AccountManagementAdapter extends BaseAdapter {
	
	public AddAccountResponse addAccount(AddAccountRequest request) {
		AccountManagementBinder binder = new AccountManagementBinder();
		AddAccountResponse response = new AddAccountResponse();
		
		try {
			//TODO: Add logs
			binder.bindAddAccountResponse(ServiceLocator.getInstance().getAccountManagementService().addNewAccount(binder.bindAccountDTOWithAddAccountRequest(request)));
		
		} catch (Exception e) {
			logger.error("AccountManagementAdapter.addAccount failed: ", e);
			response.setErrorMsg(e.getMessage());
			//TODO: Maybe msgId in finally block
		}
		
		return response;
	}	

}
