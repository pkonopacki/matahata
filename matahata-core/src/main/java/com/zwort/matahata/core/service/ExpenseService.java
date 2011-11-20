package com.zwort.matahata.core.service;

import java.util.List;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;

public interface ExpenseService extends EntityService<Expense> {
	
	List<Expense> findOutstanding() throws ServiceException;
	
	List<Expense> findExpensesByPlan(Plan plan);
	
	List<Expense> findExpensesByPlandForCategory(Plan plan, Category category);

}
