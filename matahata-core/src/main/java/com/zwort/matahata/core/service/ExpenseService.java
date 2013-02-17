package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;

import java.util.List;

public interface ExpenseService extends EntityService<Expense> {
	
	List<Expense> findOutstanding() throws ServiceException;
	
	List<Expense> findExpensesByPlan(Plan plan) throws ServiceException;
	
	List<Expense> findExpensesByPlandForCategory(Plan plan, Category category) throws ServiceException;
	
	List<Expense> findExpensesByCriteria(Expense expense) throws ServiceException;

}
