package com.zwort.matahata.core.dao;

import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Account;

public interface AccountDAO extends DictionaryDAO<Account> {
	
	public Account getByNumber(String accNumber) throws DAOException;
	
}
