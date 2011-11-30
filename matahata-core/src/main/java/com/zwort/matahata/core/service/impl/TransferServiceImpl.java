package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.TransferDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Transfer;
import com.zwort.matahata.core.service.TransferService;

public class TransferServiceImpl extends EntityServiceImpl<Transfer> implements TransferService {
	
	@Override
	public TransferDAO getDao() {
		return (TransferDAO) dao;
	}
	
	public void setDao(TransferDAO dao) {
		super.setDao(dao);
	}

	@Override
	public Transfer findLastTransferForForeignExpense(Expense expense) throws ServiceException {

		try {
			return getDao().findLastTransferForForeignExpense(expense);

		} catch (Throwable t) {
			throw new ServiceException("TransferServiceImpll#findLastTransferForForeignExpense failed", t);
		}
	}

}
