package com.zwort.matahata.core.facade;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.*;

import java.util.Date;
import java.util.List;

public interface Facade  {
	
	//public Collection<Expense> getExpenseItemsByDate(Date date);
	
	//public void saveExpenseItem(Expense expenseItem);
	
	//public ApplicationContext getContext();
	
	//Category management
	
//	public void saveCategory(Category category);
//	
//	public void deleteCategory(Category category);
	
	public List<Category> findAllCategories(boolean active) throws ServiceException;
	
	public Category getCategoryByAbbr(String abbreviation) throws ServiceException;

	public Account getAccountByNumber(String accNo) throws ServiceException;
	
	public List<Account> findActiveAccounts() throws ServiceException;
	
	public Plan getCurrentAccountPlan(Date expDate, String accNo) throws ServiceException;
	
	public Beneficiary getBeneficiaryByInitials(String initials) throws ServiceException;
	
	public Currency getCurrencyByIsoCode(String isoCode) throws ServiceException;
	
	public Currency getReferenceCurrency() throws ServiceException;
	
	//Expense management
	
	public Transfer saveTransfer(Transfer transfer) throws Exception;
	
	public Income saveIncome(Income income) throws Exception;

	public Expense saveExpense(Expense expense) throws ServiceException;
	
	//Dictionary services
	
	public Category saveCategory(Category category) throws ServiceException;
	
	public Plan savePlan(Plan plan) throws ServiceException;	
	
	public void deleteExpense(Expense expense) throws Exception;
	
	public List<Expense> findAllExpenses() throws ServiceException;
	
	public Expense findExpenseById(long id) throws Exception;
	
	public List<Expense> getExpenseListByDate(Date fromDate, Date toDate) throws Exception;
	
	public List<Expense> findOutstandingExpenses() throws Exception;

	public List<Expense> findExpensesByPlan(Plan plan) throws Exception;
	
	public Substitute getSubstitute(Month month, int year) throws ServiceException;
	
	List<Expense> findExpensesByPlanForCategory(String categoryAbbr, Month month, int year) throws ServiceException;
	
	public List<Expense> findExpensesByPlanForBeneficiary(Month month, int year) throws ServiceException;	

}
