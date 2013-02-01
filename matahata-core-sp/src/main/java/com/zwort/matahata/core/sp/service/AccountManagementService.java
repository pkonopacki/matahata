package com.zwort.matahata.core.sp.service;

import com.zwort.matahata.core.sp.dto.AccountDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import zwort.com.matahata.services._1.AccountNumberWS;

import java.util.List;

public interface AccountManagementService {
	
	public Long addNewAccount(AccountDTO dto) throws ServiceProviderException;
	
	public List<AccountDTO> getAccountsStates(List<AccountNumberWS> accountsNumbers) throws ServiceProviderException;

}
