package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.AccountDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.service.AccountService;

public class AccountServiceImpl extends DictionaryServiceImpl<Account>
		implements AccountService {

	public AccountDAO getDao() {
		return (AccountDAO) dao;
	}

	public void setDao(AccountDAO dao) {
		super.setDao(dao);
	}

	@Override
	public Account getByNumber(String accNumber) throws ServiceException {
		
		try {
			return getDao().getByNumber(accNumber);
		
		} catch (Throwable t) {
			throw new ServiceException("AccountServiceImpl#findByNumber failed: ", t);
		}
	}

}
