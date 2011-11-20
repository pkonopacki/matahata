package com.zwort.matahata.core.dao.impl;

import javax.persistence.Query;

import com.zwort.matahata.core.dao.AccountDAO;
import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Account;

public class AccountDAOJpaImpl extends DictionaryDAOJpaImpl<Account> implements
		AccountDAO {

	public AccountDAOJpaImpl() {
		super(Account.class);
	}

	public AccountDAOJpaImpl(Class<Account> type) {
		super(type);
	}

	@Override
	public Account getByNumber(String accNumber) throws DAOException {
		Query q = entityManager.createQuery("FROM Account a WHERE a.accountNumber = :accNumber");
		q.setParameter("accNumber", accNumber);
		return (Account) q.getSingleResult();
	}

}
