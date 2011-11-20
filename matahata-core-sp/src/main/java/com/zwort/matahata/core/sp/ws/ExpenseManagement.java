package com.zwort.matahata.core.sp.ws;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.zwort.matahata.core.sp.request.AddExpenseRequest;
import com.zwort.matahata.core.sp.response.AddExpenseResponse;
import com.zwort.matahata.core.sp.response.FindExpenseResponse;

@WebService(targetNamespace = "http://com.zwort/matahata/ExpenseManagement/1", name = "ExpenseManagement")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public interface ExpenseManagement {

	public AddExpenseResponse addNewExpense(@WebParam AddExpenseRequest request);
	
	public FindExpenseResponse findAllExpenses();
	
}
