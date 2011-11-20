package com.zwort.matahata.core.sp;

import com.zwort.matahata.core.service.locator.AppContext;
import com.zwort.matahata.core.sp.service.AccountManagementService;
import com.zwort.matahata.core.sp.service.CategoryManagementService;
import com.zwort.matahata.core.sp.service.ExpenseManagementService;
import com.zwort.matahata.core.sp.service.IncomeManagementService;
import com.zwort.matahata.core.sp.service.PlanManagementService;
import com.zwort.matahata.core.sp.service.SubstituteSellerService;
import com.zwort.matahata.core.sp.service.TransferManagementService;

public class ServiceLocator {
	
	//TODO: Bean names to properties
	
	private ServiceLocator() {
	
	}
	
	private static class SingletonHolder {
		private static ServiceLocator instance = new ServiceLocator();
	}
		
	public static ServiceLocator getInstance() {
		return SingletonHolder.instance;
	}
	
	public AccountManagementService getAccountManagementService() {
		return (AccountManagementService) AppContext.getApplicationContext().getBean("accountManagementService");
	}
	
	public CategoryManagementService getCategoryManagementService() {
		return (CategoryManagementService) AppContext.getApplicationContext().getBean("categoryManagementService");
	}

	public PlanManagementService getPlanManagementService() {
		return (PlanManagementService) AppContext.getApplicationContext().getBean("planManagementService");
	}

	public ExpenseManagementService getExpenseManagementService() {
		return (ExpenseManagementService) AppContext.getApplicationContext().getBean("expenseManagementService");
	}

	public TransferManagementService getTransferManagementService() {
		return (TransferManagementService) AppContext.getApplicationContext().getBean("transferManagementService");
	}
	
//	public TransferManagementBinder getTransferManagementBinder() {
//		return (TransferManagementBinder) AppContext.getApplicationContext().getBean("transferManagementBinder");
//	}

	public IncomeManagementService getIncomeManagementService() {
		return (IncomeManagementService) AppContext.getApplicationContext().getBean("incomeManagementService");
	}
	
	public SubstituteSellerService getSubstituteSellerService() {
		return (SubstituteSellerService) AppContext.getApplicationContext().getBean("substituteSellerService");
	}

}
