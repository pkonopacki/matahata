package com.zwort.matahata.ws.client.service;

import zwort.com.matahata.services._1.*;

public interface MatahataService {
	
	AddTransferResponseList addNewTransfer(AddTransferRequestList request);

	AddIncomeResponseList addNewIncome(AddIncomeRequestList request);

	AddExpenseResponseList addNewExpense(AddExpenseRequestsList request);
	
	AddPlanResponse addNewPlan(AddPlanRequest request);
}
