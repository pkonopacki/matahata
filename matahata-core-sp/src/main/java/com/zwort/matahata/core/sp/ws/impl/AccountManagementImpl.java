package com.zwort.matahata.core.sp.ws.impl;

import javax.jws.WebService;

import com.zwort.matahata.core.sp.adapter.AccountManagementAdapter;
import com.zwort.matahata.core.sp.request.AddAccountRequest;
import com.zwort.matahata.core.sp.response.AddAccountResponse;
import com.zwort.matahata.core.sp.ws.AccountManagement;

@WebService
public class AccountManagementImpl implements AccountManagement {
	
	private AccountManagementAdapter adapter;

	@Override
	public AddAccountResponse addAccount(AddAccountRequest request) {
		return adapter.addAccount(request);
	}

	public void setAdapter(AccountManagementAdapter adapter) {
		this.adapter = adapter;
	}

}
