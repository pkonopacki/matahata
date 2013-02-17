package com.zwort.matahata.core.sp.adapter;

import com.zwort.matahata.core.sp.binder.ExpenseRequestResopnseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;
import com.zwort.matahata.core.sp.service.ExpenseManagementService;
import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.AddExpenseRequestsList;
import zwort.com.matahata.services._1.AddExpenseResponseList;
import zwort.com.matahata.services._1.FindExpenseResponse;

import javax.inject.Inject;

@Component
public class ExpenseManagementAdapter extends BaseAdapter {

	@Inject
    private ExpenseManagementService expenseManagementService;

    public AddExpenseResponseList addNewExpense(AddExpenseRequestsList request) {
		AddExpenseResponseList response = new AddExpenseResponseList();
		ExpenseRequestResopnseBinder binder = new ExpenseRequestResopnseBinder();
		
		try {
			response = binder.bindAddExpenseResponseList(expenseManagementService.addNewExpense(binder.bindExpenseDtoListFromAddExpenseRequestsList(request)));
		
		} catch (Exception e) {
			logger.error("ExpenseManagementAdapter.addNewExpense failed: ", e);
			response = (AddExpenseResponseList) ErrorPropertiesUtils.setErrorInfo(response, e, "ExpenseManagementAdapter.addNewExpense failed: ");
		}
	
		return response;
	}

	public FindExpenseResponse findAllExpenses() {
		
		ExpenseRequestResopnseBinder binder = new ExpenseRequestResopnseBinder();
		FindExpenseResponse response = new FindExpenseResponse();
		
		try {
			response = binder.bindResponse(expenseManagementService.findAll());
		
		} catch (Exception e) {
			logger.error("ExpenseManagementAdapter.findAllExpenses failed: ", e);
			response = (FindExpenseResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "ExpenseManagementAdapter.findAllExpenses failed: ");
		}
	
		return response;
	}
}
