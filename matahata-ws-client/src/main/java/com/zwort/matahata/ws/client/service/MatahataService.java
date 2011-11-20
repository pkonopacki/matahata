package com.zwort.matahata.ws.client.service;

import zwort.com.matahata.services._1.AddExpenseRequestsList;
import zwort.com.matahata.services._1.AddExpenseResponseList;
import zwort.com.matahata.services._1.AddIncomeRequestList;
import zwort.com.matahata.services._1.AddIncomeResponseList;
import zwort.com.matahata.services._1.AddPlanRequest;
import zwort.com.matahata.services._1.AddPlanResponse;
import zwort.com.matahata.services._1.AddTransferRequestList;
import zwort.com.matahata.services._1.AddTransferResponseList;

public interface MatahataService {
	
	AddTransferResponseList addNewTransfer(AddTransferRequestList request);

	AddIncomeResponseList addNewIncome(AddIncomeRequestList request);

	AddExpenseResponseList addNewExpense(AddExpenseRequestsList request);
	
	AddPlanResponse addNewPlan(AddPlanRequest request);
}
