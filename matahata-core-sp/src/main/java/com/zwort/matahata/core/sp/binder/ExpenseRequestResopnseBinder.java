package com.zwort.matahata.core.sp.binder;

import java.util.ArrayList;
import java.util.List;

import zwort.com.matahata.services._1.AddExpenseRequest;
import zwort.com.matahata.services._1.AddExpenseRequestsList;
import zwort.com.matahata.services._1.AddExpenseResponse;
import zwort.com.matahata.services._1.AddExpenseResponseList;
import zwort.com.matahata.services._1.ExpenseWS;
import zwort.com.matahata.services._1.ExpensesWSList;
import zwort.com.matahata.services._1.FindExpenseResponse;

import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;
import com.zwort.matahata.core.sp.util.ConversionUtils;

public class ExpenseRequestResopnseBinder {
	
	public FindExpenseResponse bindResponse(List<Expense> expensesList) {
		FindExpenseResponse response = new FindExpenseResponse();
		ExpensesWSList expenseWSList = new ExpensesWSList();
		List<ExpenseWS> expensesRespList = new ArrayList<ExpenseWS>();
		
		for (Expense e : expensesList) {
			ExpenseWS exp = new ExpenseWS();
			exp.setDate(ConversionUtils.dateToXmlGregorianCalendar(e.getDate()));
			exp.setCategoryDesc(e.getCategory().getDescription());
			exp.setAmount(e.getAmount());
			expensesRespList.add(exp);
		}
		expenseWSList.getExpenseWS().addAll(expensesRespList);
		response.setExpensesWSList(expenseWSList);
		return response;
	}
	
	public AddExpenseResponseList bindAddExpenseResponseList(List<Long> idsList) {
		AddExpenseResponseList response = new AddExpenseResponseList();
		List<AddExpenseResponse> responseList = new ArrayList<AddExpenseResponse>();
		
		for (Long id : idsList) {
			AddExpenseResponse resp = bindAddExpenseResponse(id);
			responseList.add(resp);
		}
		response.getAddExpenseResponsesList().addAll(responseList);
		
		return response;
	}
	
	public AddExpenseResponse bindAddExpenseResponse(Long id) {
		AddExpenseResponse response = new AddExpenseResponse();
		response.setId(id);
		
		return response;
		
	}
	
	public List<ExpenseDTO> bindExpenseDtoListFromAddExpenseRequestsList(AddExpenseRequestsList addNewExpense) {
		List<ExpenseDTO> expenseDtosList = new ArrayList<ExpenseDTO>();
		
		for (AddExpenseRequest req : addNewExpense.getAddExpenseRequestsList()) {
			ExpenseDTO dto = bindExpenseDtoWithAddExpenseRequest(req);
			expenseDtosList.add(dto);
		}
		return expenseDtosList;
	}
	
	public ExpenseDTO bindExpenseDtoWithAddExpenseRequest(AddExpenseRequest request) {
		ExpenseDTO dto = new ExpenseDTO();
		
		dto.setAmount(request.getAmount());
		dto.setBeneficiaryInitials(request.getBeneficiaryInitials());
		dto.setCategoryAbbr(request.getCategoryAbbr());
		dto.setCleared(request.isCleared() != null ? request.isCleared() : false);
		dto.setRefundable(request.isRefundable() != null ? request.isRefundable() : false);
		dto.setDate(ConversionUtils.xmlGregorianCalendarToDate(request.getDate()));
		dto.setDescription(request.getDescription());
		dto.setLocation(request.getLocation());
		dto.setOriginalAmount(request.getOriginalAmount());
		dto.setOriginalCurrencyISO(request.getOriginalCurrencyISO());
		dto.setPayerInitials(request.getPayerInitials());
		dto.setSrcAccountNo(request.getSrcAccountNo());

		return dto;
	}
	
}
