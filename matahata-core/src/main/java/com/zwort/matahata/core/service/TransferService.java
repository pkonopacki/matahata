package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Transfer;


public interface TransferService extends EntityService<Transfer>{
	
	public Transfer findLastTransferForForeignExpense(Expense expense) throws ServiceException;

}
