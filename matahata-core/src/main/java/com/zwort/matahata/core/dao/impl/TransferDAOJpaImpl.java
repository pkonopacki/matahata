package com.zwort.matahata.core.dao.impl;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.dao.TransferDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Income;
import com.zwort.matahata.core.model.Transfer;
import org.springframework.stereotype.Repository;

@Repository(value = "transferDAO")
public class TransferDAOJpaImpl extends EntityDAOJpaImpl<Transfer> implements TransferDAO {

	private static final Log logger = LogFactory.getLog(TransferDAOJpaImpl.class);

	public TransferDAOJpaImpl() {
		this(Transfer.class);
	}

	public TransferDAOJpaImpl(Class<Transfer> type) {
		super(type);
	}

	@Override
	public Transfer findLastTransferForForeignExpense(Expense expense)
			throws ServiceException {

		Query q = entityManager.createQuery("FROM Transfer t WHERE t.originalCurrency = :currency and t.destAccount = :account and t.date <= :date order by t.date desc");
		
		logger.debug("KRP: Date " + expense.getDate());
        logger.debug("KRP: Location " + expense.getLocation());
        logger.debug("KRP: Account " + expense.getSrcAccount().getAccountNumber());
		logger.debug("KRP: Currency " + expense.getOriginalCurrency().getIsoCode());
		
		q.setParameter("date", expense.getDate());
		q.setParameter("account", expense.getSrcAccount());
		q.setParameter("currency", expense.getOriginalCurrency());

		q.setMaxResults(1);
	
		return (Transfer) q.getSingleResult();
	}

	@Override
	public Transfer findLastTransferForForeignIncome(Income income)
			throws ServiceException {

		Query q = entityManager.createQuery("FROM Transfer t WHERE t.originalCurrency = :currency and t.date <= :date order by t.date desc");
		
		logger.debug("KRP: Date " + income.getDate());
		
		q.setParameter("date", income.getDate());
		q.setParameter("currency", income.getOriginalCurrency());

		q.setMaxResults(1);
	
		return (Transfer) q.getSingleResult();
	}

}
