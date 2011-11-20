package com.zwort.matahata.core.sp.assembler;

import java.util.ArrayList;
import java.util.List;

import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;

public class ExpenseDTOAssembler {
	
	public List<ExpenseDTO> assembleDtoListFromExpensesList(List<Expense> expensesList) {
		List<ExpenseDTO> dtosList = new ArrayList<ExpenseDTO>();
		
		for (Expense exp : expensesList) {
			ExpenseDTO dto = bindExpenseDtoFromExpense(exp);
			dtosList.add(dto);
		}
		
		return dtosList;
	}

	private ExpenseDTO bindExpenseDtoFromExpense(Expense exp) {
		ExpenseDTO dto = new ExpenseDTO();
		dto.setAmount(exp.getAmount());
		dto.setCurrencyIso(exp.getCurrency().getIsoCode());
		dto.setBeneficiaryInitials(exp.getBeneficiary().getInitials());
		dto.setCategoryAbbr(exp.getCategory().getAbbreviation());
		dto.setCategoryDesc(exp.getCategory().getDescription());
		dto.setCleared(exp.isCleared());
		dto.setDate(exp.getDate());
		dto.setDescription(exp.getDescription());
		dto.setLocation(exp.getLocation());
		dto.setOriginalAmount(exp.getOriginalAmount());
		dto.setOriginalCurrencyISO(exp.getOriginalCurrency().getIsoCode());
		dto.setPayerInitials(exp.getPayer().getInitials());
		dto.setRefundable(exp.isRefundable());
		dto.setSrcAccountNo(exp.getSrcAccount().getAccountNumber());
		
		return dto;
	}

}