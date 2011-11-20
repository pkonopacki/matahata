package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.CurrencyDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.service.CurrencyService;

public class CurrencyServiceImpl extends DictionaryServiceImpl<Currency>
		implements CurrencyService {

	
	public CurrencyDAO getDao() {
		return (CurrencyDAO) dao;
	}

	public void setDao(CurrencyDAO dao) {
		this.dao = dao;
	}

	@Override
	public Currency getByIsoCode(String isoCode) throws ServiceException {

		try {
			return getDao().getByISOCode(isoCode);
		
		} catch (Throwable t) {
			throw new ServiceException("CurrencyServiceImpl#findByIsoCode failed: ", t);
		}
	}

	@Override
	public Currency getReferenceCurrency() throws ServiceException {

		try {
			return getDao().getReferenceCurrency();
		
		} catch (Throwable t) {
			throw new ServiceException("CurrencyServiceImpl#findByIsoCode failed: ", t);
		}
	}

}
