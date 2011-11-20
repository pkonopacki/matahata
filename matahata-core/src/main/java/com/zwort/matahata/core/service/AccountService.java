package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;

public interface AccountService extends DictionaryService<Account> {
	
	public Account getByNumber(String accNumber) throws ServiceException;

}
