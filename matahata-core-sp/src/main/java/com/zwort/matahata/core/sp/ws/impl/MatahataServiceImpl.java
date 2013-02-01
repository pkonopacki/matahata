package com.zwort.matahata.core.sp.ws.impl;

import com.zwort.matahata.core.sp.adapter.ExpenseManagementAdapter;
import com.zwort.matahata.core.sp.adapter.IncomeManagementAdapter;
import com.zwort.matahata.core.sp.adapter.PlanManagementAdapter;
import com.zwort.matahata.core.sp.adapter.TransferManagementAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import zwort.com.matahata.services._1.*;

public class MatahataServiceImpl implements MatahataServicePortType {

    @Autowired
	private TransferManagementAdapter transferManagementAdapter;

    @Autowired
	private ExpenseManagementAdapter expenseManagementAdapter;

    @Autowired
	private IncomeManagementAdapter incomeManagementAdapter;
	
	@Autowired
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

}
