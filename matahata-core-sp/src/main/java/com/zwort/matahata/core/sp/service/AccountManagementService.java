package com.zwort.matahata.core.sp.service;

import com.zwort.matahata.core.sp.dto.AccountDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public interface AccountManagementService {
	
	public Long addNewAccount(AccountDTO dto) throws ServiceProviderException;

}
