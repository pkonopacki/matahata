package com.zwort.matahata.core.sp.service;

import java.util.List;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public interface ExpenseManagementService {
	
	List<Long> addNewExpense(List<ExpenseDTO> dto) throws ServiceProviderException;
	
	List<Expense> findAll() throws ServiceException ;
	
	//TODO: Another methods will come here...

}
