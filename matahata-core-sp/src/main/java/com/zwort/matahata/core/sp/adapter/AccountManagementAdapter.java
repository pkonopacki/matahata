package com.zwort.matahata.core.sp.adapter;

import zwort.com.matahata.services._1.GetAccountStateRequestList;
import zwort.com.matahata.services._1.GetAccountStateResponse;

import com.zwort.matahata.core.sp.ServiceLocator;
import com.zwort.matahata.core.sp.binder.AccountManagementRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;
import com.zwort.matahata.core.sp.request.AddAccountRequest;
import com.zwort.matahata.core.sp.response.AddAccountResponse;

public class AccountManagementAdapter extends BaseAdapter {
	
	public AddAccountResponse addAccount(AddAccountRequest request) {
		AccountManagementRequestResponseBinder binder = new AccountManagementRequestResponseBinder();
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
	
	public GetAccountStateResponse getAccountState(GetAccountStateRequestList accountsStatesRequestList) {
		AccountManagementRequestResponseBinder binder = new AccountManagementRequestResponseBinder();
		GetAccountStateResponse response = null;
		
		try {
			response = binder.bindGetAccStateResponse(ServiceLocator.getInstance().getAccountManagementService().getAccountsStates(accountsStatesRequestList.getAccountNumbersList().getAccountNumberWS()));

		} catch (Exception e) {
			logger.error("AccountManagementAdapter.getAccountState failed: ", e);
			response = (GetAccountStateResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "AccountManagementAdapter.getAccountState failed: ");
		}
		
		return response;
	}

}
