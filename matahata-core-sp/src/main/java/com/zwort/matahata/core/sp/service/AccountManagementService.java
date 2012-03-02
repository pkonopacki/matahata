package com.zwort.matahata.core.sp.service;

import java.util.List;

import zwort.com.matahata.services._1.AccountNumberWS;

import com.zwort.matahata.core.sp.dto.AccountDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public interface AccountManagementService {
	
	public Long addNewAccount(AccountDTO dto) throws ServiceProviderException;
	
	public List<AccountDTO> getAccountsStates(List<AccountNumberWS> accountsNumbers) throws ServiceProviderException;

}
