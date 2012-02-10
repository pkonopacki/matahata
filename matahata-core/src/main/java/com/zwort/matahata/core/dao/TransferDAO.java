package com.zwort.matahata.core.dao;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Income;
import com.zwort.matahata.core.model.Transfer;

public interface TransferDAO extends EntityDAO<Transfer> {
	
	public Transfer findLastTransferForForeignExpense(Expense expense) throws ServiceException;

	Transfer findLastTransferForForeignIncome(Income expense)
			throws ServiceException;

}
