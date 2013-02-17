package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.AccountDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.service.AccountService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.persistence.NoResultException;

@Service
public class AccountServiceImpl extends DictionaryServiceImpl<Account>
		implements AccountService {

    public AccountDAO getDao() {
		return (AccountDAO) dao;
	}

	//TODO: What can we do???
    @Inject
    public void setDao(AccountDAO dao) {
		super.setDao(dao);
	}

	@Override
	public Account getByNumber(String accNumber) throws ServiceException {
		
		try {
			return getDao().getByNumber(accNumber);
		
        } catch (NoResultException nre) {
            throw new ServiceException("AccountServiceImpl#getByNumber failed. No account with number [" + accNumber + "] found.");

		} catch (Throwable t) {
			throw new ServiceException("AccountServiceImpl#getByNumber failed: " +  t.getMessage(), t);
		}
	}

}
