package com.zwort.matahata.core.sp.binder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.sp.dto.AccountDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public class AccountManagementBinder extends CommonBinder {
	
	private static final Log logger = LogFactory.getLog(AccountManagementBinder.class);
	
	public Account bindAccount(AccountDTO dto)  throws ServiceException, ServiceProviderException {
		logger.debug("Returning account with number: " + dto.getAccountNumber());
		return getAccount(dto.getAccountNumber());
	}

}
