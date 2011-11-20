package com.zwort.matahata.core.sp.ws.impl;

import zwort.com.matahata.services._1.AddExpenseRequestsList;
import zwort.com.matahata.services._1.AddExpenseResponseList;
import zwort.com.matahata.services._1.AddIncomeRequestList;
import zwort.com.matahata.services._1.AddIncomeResponseList;
import zwort.com.matahata.services._1.AddPlanRequest;
import zwort.com.matahata.services._1.AddPlanResponse;
import zwort.com.matahata.services._1.AddTransferRequestList;
import zwort.com.matahata.services._1.AddTransferResponseList;
import zwort.com.matahata.services._1.MatahataServicePortType;

import com.zwort.matahata.core.sp.adapter.ExpenseManagementAdapter;
import com.zwort.matahata.core.sp.adapter.IncomeManagementAdapter;
import com.zwort.matahata.core.sp.adapter.PlanManagementAdapter;
import com.zwort.matahata.core.sp.adapter.TransferManagementAdapter;

public class MatahataServiceImpl implements MatahataServicePortType {
	
	private TransferManagementAdapter transferManagementAdapter;
	
	private ExpenseManagementAdapter expenseManagementAdapter;
	
	private IncomeManagementAdapter incomeManagementAdapter;
	
	private PlanManagementAdapter planManagementAdapter;

	@Override
	public AddPlanResponse addNewPlan(AddPlanRequest addNewPlan) {
		return planManagementAdapter.addNewPlan(addNewPlan);
	}

	@Override
	public AddTransferResponseList addNewTransfer(AddTransferRequestList addNewTransfer) {
		return transferManagementAdapter.addNewTransfer(addNewTransfer);
	}

	@Override
	public AddIncomeResponseList addNewIncome(AddIncomeRequestList addNewIncome) {
		return incomeManagementAdapter.addNewIncome(addNewIncome);
	}


	@Override
	public AddExpenseResponseList addNewExpense(AddExpenseRequestsList addNewExpense) {
		return expenseManagementAdapter.addNewExpense(addNewExpense);
	}
	
	
	//Spring setters
	
	public void setTransferManagementAdapter(
			TransferManagementAdapter transferManagementAdapter) {
		this.transferManagementAdapter = transferManagementAdapter;
	}

	public void setExpenseManagementAdapter(
			ExpenseManagementAdapter expenseManagementAdapter) {
		this.expenseManagementAdapter = expenseManagementAdapter;
	}

	public void setIncomeManagementAdapter(
			IncomeManagementAdapter incomeManagementAdapter) {
		this.incomeManagementAdapter = incomeManagementAdapter;
	}

	public void setPlanManagementAdapter(PlanManagementAdapter planManagementAdapter) {
		this.planManagementAdapter = planManagementAdapter;
	}
	
}
