package com.zwort.matahata.core.dao;

import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;

import java.util.List;

public interface ExpenseDAO extends EntityDAO<Expense> {

	List<Expense> findOutstanding();
	
	List<Expense> findByPlan(Plan plan);
	
	List<Expense> findByPlanForCategory(Plan plan, Category category);
	
	List<Expense> findByCriteria(Expense expense);

}
