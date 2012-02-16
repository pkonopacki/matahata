package com.zwort.matahata.core.sp.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import zwort.com.matahata.services._1.AddExpenseRequest;
import zwort.com.matahata.services._1.AddExpenseResponse;
import zwort.com.matahata.services._1.FindExpenseResponse;

//import com.zwort.matahata.core.sp.request.AddExpenseRequest;

@WebService(targetNamespace = "http://com.zwort/matahata/ExpenseManagement/1", name = "ExpenseManagement")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public interface ExpenseManagement {

	public AddExpenseResponse addNewExpense(@WebParam AddExpenseRequest request);
	
	public FindExpenseResponse findAllExpenses();
	
}
