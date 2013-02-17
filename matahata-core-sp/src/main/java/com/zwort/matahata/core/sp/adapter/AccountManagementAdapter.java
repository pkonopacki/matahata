package com.zwort.matahata.core.sp.adapter;

import com.zwort.matahata.core.sp.binder.AccountManagementRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;
import com.zwort.matahata.core.sp.request.AddAccountRequest;
import com.zwort.matahata.core.sp.response.AddAccountResponse;
import com.zwort.matahata.core.sp.service.AccountManagementService;
import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.GetAccountStateRequestList;
import zwort.com.matahata.services._1.GetAccountStateResponse;

import javax.inject.Inject;

@Component
public class AccountManagementAdapter extends BaseAdapter {
	
	@Inject
    private AccountManagementService accountManagementService;

    public AddAccountResponse addAccount(AddAccountRequest request) {
		AccountManagementRequestResponseBinder binder = new AccountManagementRequestResponseBinder();
		AddAccountResponse response = new AddAccountResponse();
		
		try {
			//TODO: Add logs
			binder.bindAddAccountResponse(accountManagementService.addNewAccount(binder.bindAccountDTOWithAddAccountRequest(request)));
		
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
			response = binder.bindGetAccStateResponse(accountManagementService.getAccountsStates(accountsStatesRequestList.getAccountNumbersList().getAccountNumberWS()));

		} catch (Exception e) {
			logger.error("AccountManagementAdapter.getAccountState failed: ", e);
			response = (GetAccountStateResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "AccountManagementAdapter.getAccountState failed: ");
		}
		
		return response;
	}

}
