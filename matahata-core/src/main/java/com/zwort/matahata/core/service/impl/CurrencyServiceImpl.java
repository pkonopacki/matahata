package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.CurrencyDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.service.CurrencyService;

import javax.persistence.NoResultException;

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

        } catch (NoResultException nre) {
            throw new ServiceException("CurrencyServiceImpl#getByfindByIsoCodeNumber failed. No currency with ISO code [" + isoCode + "] found.");

        } catch (Throwable t) {
			throw new ServiceException("CurrencyServiceImpl#findByIsoCode failed: " + t.getMessage(), t);
		}
	}

	@Override
	public Currency getReferenceCurrency() throws ServiceException {

		try {
			return getDao().getReferenceCurrency();

        } catch (NoResultException nre) {
            throw new ServiceException("CurrencyServiceImpl#getReferenceCurrency failed. No reference currency defined.");

        } catch (Throwable t) {
			throw new ServiceException("CurrencyServiceImpl#getReferenceCurrency failed: " + t.getMessage(), t);
		}
	}

}
