package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Currency;

public interface CurrencyService extends DictionaryService<Currency> {
	
	public Currency getByIsoCode(String isoCode) throws ServiceException;
	
	public Currency getReferenceCurrency() throws ServiceException;

}
