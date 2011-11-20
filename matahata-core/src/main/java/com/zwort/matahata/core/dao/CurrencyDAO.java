package com.zwort.matahata.core.dao;

import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Currency;

public interface CurrencyDAO extends DictionaryDAO<Currency> {

	public Currency getByISOCode(String isoCode) throws DAOException;
	
	public Currency getReferenceCurrency() throws DAOException;

}
