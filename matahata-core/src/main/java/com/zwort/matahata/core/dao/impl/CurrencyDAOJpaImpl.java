package com.zwort.matahata.core.dao.impl;

import com.zwort.matahata.core.dao.CurrencyDAO;
import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Currency;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository(value = "currencyDAO")
public class CurrencyDAOJpaImpl extends DictionaryDAOJpaImpl<Currency>
		implements CurrencyDAO {

	public CurrencyDAOJpaImpl() {
		super(Currency.class);
	}

	public CurrencyDAOJpaImpl(Class<Currency> type) {
		super(type);
	}

	@Override
	public Currency getByISOCode(String isoCode) throws DAOException {
		Query q = entityManager.createQuery("FROM Currency c where c.isoCode = :isoCode");
		q.setParameter("isoCode", isoCode);
		return (Currency) q.getSingleResult();
	}

	@Override
	public Currency getReferenceCurrency() throws DAOException {
		Query q = entityManager.createQuery("FROM Currency c where c.defaultCurrency = :defaultCurrency");
		q.setParameter("defaultCurrency", true);
		return (Currency) q.getSingleResult();
	}

}
