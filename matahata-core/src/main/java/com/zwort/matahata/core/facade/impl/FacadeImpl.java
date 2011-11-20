package com.zwort.matahata.core.facade.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.facade.Facade;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.model.Beneficiary;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Credit;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.model.Debit;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Income;
import com.zwort.matahata.core.model.Month;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.PlanItem;
import com.zwort.matahata.core.model.Substitute;
import com.zwort.matahata.core.model.Transfer;
import com.zwort.matahata.core.service.AccountService;
import com.zwort.matahata.core.service.BeneficiaryService;
import com.zwort.matahata.core.service.CategoryService;
import com.zwort.matahata.core.service.CurrencyService;
import com.zwort.matahata.core.service.EntityService;
import com.zwort.matahata.core.service.ExpenseService;
import com.zwort.matahata.core.service.PlanService;
import com.zwort.matahata.core.substitute.SubstituteService;
import com.zwort.matahata.core.utils.DateUtils;

/**
 * @author  pedro
 */
public class FacadeImpl implements Facade {
	
	private static final Log logger = LogFactory.getLog(FacadeImpl.class);
	
	private ExpenseService expenseService;
	
	private EntityService<Transfer> transferService;

	private EntityService<Income> incomeService;

	private EntityService<Debit> debitService;
	
	private EntityService<Credit> creditService;

	private AccountService accountService;
	
	private CategoryService categoryService;
	
	private CurrencyService currencyService;

	private PlanService planService;

	private BeneficiaryService beneficiaryService;

	private SubstituteService substituteService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public void setExpenseService(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	public void setTransferService(EntityService<Transfer> transferService) {
		this.transferService = transferService;
	}

	public void setIncomeService(EntityService<Income> incomeService) {
		this.incomeService = incomeService;
	}

	public void setDebitService(EntityService<Debit> debitService) {
		this.debitService = debitService;
	}

	public void setCreditService(EntityService<Credit> creditService) {
		this.creditService = creditService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}
	
	public void setPlanService(PlanService planService) {
		this.planService = planService;
	}
	
	public void setBeneficiaryService(BeneficiaryService beneficiaryService) {
		this.beneficiaryService = beneficiaryService;
	}
	
	public void setSubstituteService(SubstituteService substituteService) {
		this.substituteService = substituteService;
	}
	
	
//	public void saveCategory(Category category) {
//		categoryService.add(category);
//	}
//
//	public void deleteCategory(Category category) {
//		categoryService.delete(category);
//	}

//	public Category findCategoryById(long id) {
//		return categoryService.findById(id);
//	}

//	public List<Category> findAllCategories() {
//		return categoryService.findAll();
//	}

//	public Category findCategoryByAbbr(String arg0) {
//		return categoryService.findByAbbr(arg0);
//	}


//	public long saveOperation(Operation operation) throws Exception {
//		return operationService.store(operation);
//	}

	@Override
	@Transactional
	public Transfer saveTransfer(Transfer transfer) throws Exception {
		Account accSrc = transfer.getSrcAccount();
		Account accDest = transfer.getDestAccount();
		double balanceSrc = accSrc.getBalance();
		double balanceDest = accDest.getBalance();
		//TODO: Change to ref and different currencies in the future...
		Currency srcAccCurrency = accSrc.getCurrency();
		Currency destAccCurrency = accDest.getCurrency();
		Currency refCurrency = currencyService.getReferenceCurrency();
		Currency originalCurrency = transfer.getOriginalCurrency();
		
		double amount = transfer.getAmount();
		double originalAmount = transfer.getOriginalAmount();
		Transfer transferRet = transferService.add(transfer);

		Debit operationDeb = new Debit();
		Credit operationCr = new Credit();
		
		operationDeb.setAccount(accSrc);
		operationDeb.setAmount(amount);
		operationDeb.setCurrency(refCurrency);
		operationDeb.setOriginalAmount(transfer.getOriginalAmount());
		operationDeb.setOriginalCurrency(originalCurrency);
		operationDeb.setItem(transferRet);
		operationDeb.setDate(new java.sql.Date(transfer.getDate().getTime()));
		operationCr.setAccount(accDest);
		operationCr.setAmount(amount);
		operationCr.setCurrency(refCurrency);
		operationCr.setOriginalAmount(transfer.getOriginalAmount());
		operationCr.setOriginalCurrency(originalCurrency);
		operationCr.setItem(transferRet);
		operationCr.setDate(new java.sql.Date(transfer.getDate().getTime()));

		//TODO: to the contrary :)
		
		if (!refCurrency.equals(srcAccCurrency)) {
			accSrc.setBalance(balanceSrc - originalAmount);
			accDest.setBalance(balanceDest + amount);
			
		} else if (!refCurrency.equals(destAccCurrency)) {
			accSrc.setBalance(balanceSrc - amount);
			accDest.setBalance(balanceDest + originalAmount);
		
		} else if (refCurrency.equals(srcAccCurrency) && refCurrency.equals(destAccCurrency)) {
			accSrc.setBalance(balanceSrc - amount);
			accDest.setBalance(balanceDest + amount);
			
		} else {
			throw new ServiceException("One of the currencies must be a reference currency");
		}
		accountService.update(accSrc);
		accountService.update(accDest);
		creditService.add(operationCr);
		debitService.add(operationDeb);

		return transferRet;
		
	}
	
	@Override
	@Transactional
	public Income saveIncome(Income income) throws Exception {
		Account acc = income.getDestAccount();
		double balance = acc.getBalance();
		double amount = income.getAmount();
		Income retValue = incomeService.add(income);
		Credit operation = new Credit();
		operation.setAccount(income.getDestAccount());
		operation.setCurrency(income.getCurrency());
		operation.setAmount(amount);
		operation.setOriginalCurrency(income.getOriginalCurrency());
		operation.setOriginalAmount(income.getOriginalAmount());
		operation.setItem(retValue);
		operation.setDate(new java.sql.Date(income.getDate().getTime()));
		acc.setBalance(balance + amount);
		accountService.update(acc);
		creditService.add(operation);

		return retValue;
	
	}
	
	@Override
	@Transactional
	public Expense saveExpense(Expense expense) throws ServiceException {
		logger.debug("FacadeImpl#saveExpense start");
		Account acc = expense.getSrcAccount();
		Currency originalCurrency = (acc.getCurrency());
		double balance = acc.getBalance();
		double amount = expense.getOriginalAmount();
		Expense savedExpense = expenseService.add(expense);
		Debit operation = new Debit();
		//Category category = savedExpense.getCategory();
		//TODO: Adding categories to expenses
		//category.getExpenses().add(savedExpense);
		//categoryService.update(category);
		operation.setAccount(savedExpense.getSrcAccount());
		operation.setCurrency(savedExpense.getCurrency());
		operation.setOriginalCurrency(originalCurrency);
		operation.setOriginalAmount(savedExpense.getOriginalAmount());
		operation.setAmount(amount);
		operation.setItem(savedExpense);
		operation.setDate(new java.sql.Date(savedExpense.getDate().getTime()));
		acc.setBalance(balance - amount);
		accountService.update(acc);
		debitService.add(operation);
		logger.debug("FacadeImpl#saveExpense end");

		return savedExpense;
	
	}
	
	@Override
	public List<Expense> findAllExpenses() throws ServiceException {
		return expenseService.findAll();
	}
	
	
	@Override
	public List<Expense> getExpenseListByDate(Date fromDate, Date toDate) throws Exception {
		return expenseService.findByDates(fromDate, toDate);
	}
	

	@Override
	public Expense findExpenseById(long id) throws Exception {
		return expenseService.findById(id);
	}
	

	@Override
	public List<Expense> findOutstandingExpenses() throws Exception {
		return expenseService.findOutstanding();
	}

	@Override
	public void deleteExpense(Expense expense) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category getCategoryByAbbr(String abbr) throws ServiceException {
		return categoryService.getByAbbreviation(abbr);
	}

	@Override
	public Account getAccountByNumber(String accNo) throws ServiceException {
		return accountService.getByNumber(accNo);
	}

	@Override
	public Plan getCurrentAccountPlan(Date expDate, String accNo) throws ServiceException {
		return planService.getPlanByDate(expDate);
	}

	@Override
	public Beneficiary getBeneficiaryByInitials(String initials) throws ServiceException {
		return beneficiaryService.getByInitials(initials);
	}

	@Override
	public Currency getCurrencyByIsoCode(String isoCode) throws ServiceException {
		return currencyService.getByIsoCode(isoCode);
	}

	@Override
	public Currency getReferenceCurrency() throws ServiceException {
		return currencyService.getReferenceCurrency();
	}

	@Override
	public List<Category> findAllCategories(boolean active) throws ServiceException {
		if (active) {
			return categoryService.findActive();
		
		} else {
			return categoryService.findActive();
		}
	}

	@Override
	public List<Expense> findExpensesByPlan(Plan plan) throws Exception {
		return expenseService.findExpensesByPlan(plan);
	}

	@Override
	public Category saveCategory(Category category) throws ServiceException {
		return categoryService.add(category);
	}
	
	@Override
	public Plan savePlan(Plan plan) throws ServiceException {
		List<Category> categoriesList = categoryService.findActive();
		Set<Category> planCategoriesList = new HashSet<Category>();
		
		for (PlanItem planItem : plan.getPlanItemsList()) {
			planCategoriesList.add(planItem.getCategory());
		}
		
		for (Category category : categoriesList) {
			
			if (!planCategoriesList.contains(category)) {
				PlanItem planItem = new PlanItem();
				planItem.setCategory(category);
				planItem.setAmount(category.getMonthlyLimit());
				plan.getPlanItemsList().add(planItem);
			}
		}
		
		
		
		return planService.add(plan);
	}

	@Override
	public Substitute getSubstitute(Month month) throws ServiceException {
		//TODO: Change logic (flexible plans / dates)
		logger.debug("FacadeImpl#getSubstitute start");
		logger.debug("Month: " + month);
		logger.debug("Date from month: " + DateUtils.getBeginningDate(month));

		Plan plan = planService.getPlanByDate(DateUtils.getBeginningDate(month));
		
		logger.debug("Plan beginning date: " + plan.getStartDate());
		logger.debug("Plan end date: " + plan.getEndDate());
		
		List<Expense> expenses = expenseService.findExpensesByPlan(plan);

		logger.debug("FacadeImpl#getSubstitute end");
		
		return substituteService.getSubstitute(plan, expenses);
	}
	
	public List<Expense> findExpensesByPlanForCategory(String categoryAbbr, Month month) throws ServiceException {
		Plan plan = planService.getPlanByDate(DateUtils.getBeginningDate(month));
		Category category = categoryService.getByAbbreviation(categoryAbbr);
		return expenseService.findExpensesByPlandForCategory(plan, category);
	}
	
}