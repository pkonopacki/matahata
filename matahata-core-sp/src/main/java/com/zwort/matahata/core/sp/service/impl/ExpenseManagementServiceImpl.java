package com.zwort.matahata.core.sp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.sp.binder.ExpenseManagementBinder;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.ExpenseManagementService;

public class ExpenseManagementServiceImpl extends AbstractManagementService implements ExpenseManagementService {
	
	private static final Log logger = LogFactory.getLog(ExpenseManagementServiceImpl.class);
	
	private ExpenseManagementBinder binder;
	

	@Override
	public List<Long> addNewExpense(List<ExpenseDTO> dtosList) throws ServiceProviderException {
		List<Long> returnValue = new ArrayList<Long>();

		try {
		
			for (ExpenseDTO dto : dtosList) {
				Long id = facade.saveExpense(binder.bindExpense(dto)).getId();
				returnValue.add(id);
			}
			
		} catch (Throwable t) {
			logger.error("ExpenseManagementServiceImpl.addNewExpense failed: ", t);
			throw new ServiceProviderException("ExpenseManagementServiceImpl.addNewExpense failed: ", t);
		}
	
		return returnValue;

	}

	@Override
	public List<Expense> findAll() throws ServiceException {
		return facade.findAllExpenses();
	}

	//Spring setters
	
	public void setBinder(ExpenseManagementBinder binder) {
		this.binder = binder;
	}

}
