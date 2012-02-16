package com.zwort.matahata.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.dao.ExpenseDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.facade.impl.FacadeImpl;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.service.ExpenseService;

public class ExpenseServiceImpl extends EntityServiceImpl<Expense> implements ExpenseService {
	
	private static final Log logger = LogFactory.getLog(FacadeImpl.class);


	public void setDao(ExpenseDAO dao) {
		super.setDao(dao);
	}

	@Override
	public ExpenseDAO getDao() {
		return (ExpenseDAO) dao;
	}
	

	@Override
	public List<Expense> findOutstanding() throws ServiceException {
		logger.info("ExpenseServiceImpl#findOutstanding start");
		try {
			return getDao().findOutstanding();
		
		} catch (Throwable t) {
			throw new ServiceException("ExpenseServiceImpl#findOutstanding failed", t);
		}
	}

	@Override
	public List<Expense> findExpensesByPlan(Plan plan) {
		return getDao().findByPlan(plan);
	}

	@Override
	public List<Expense> findExpensesByPlandForCategory(Plan plan,
			Category category) {
		return getDao().findByPlanForCategory(plan, category);
	}

	@Override
	public List<Expense> findExpensesByCriteria(Expense expense)
			throws ServiceException {
		return getDao().findByCriteria(expense);
	}
	
	
	

}
