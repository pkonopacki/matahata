package com.zwort.matahata.core.sp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Month;
import com.zwort.matahata.core.model.Substitute;
import com.zwort.matahata.core.sp.assembler.ExpenseDTOAssembler;
import com.zwort.matahata.core.sp.assembler.SubstituteDtoAssembler;
import com.zwort.matahata.core.sp.dto.CriteriaDTO;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;
import com.zwort.matahata.core.sp.dto.SubstituteDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.SubstituteSellerService;

public class SubstituteSellerServiceImpl extends AbstractManagementService implements SubstituteSellerService {
	
	private static final Log logger = LogFactory.getLog(IncomeManagementServiceImpl.class);

//	@SuppressWarnings("unused")
//	private StatsConfig statsConfig;
	

	@Override
	public SubstituteDTO sellSubstitute(Month month, int year) throws ServiceProviderException {
		Substitute substitute = null;
		SubstituteDtoAssembler substituteDtoAssembler = new SubstituteDtoAssembler();
		
		try {
			substitute = facade.getSubstitute(month, year);
		
		} catch (Exception e){
			logger.error("SubstituteSellerServiceImpl.sellSubstitute failed: ", e);
			throw new ServiceProviderException("SubstituteSellerServiceImpl.sellSubstitute ", e);
		}
		
		return substituteDtoAssembler.assembleSubstitute(substitute);
	}

	@SuppressWarnings("unused")
	private Map<Category, Double> getEpensesByCategory(List<Expense> expenses) {
		Map<Category, Double> expensesByCategoryMap = new HashMap<Category, Double>();
		
		for (Expense exp : expenses) {
			
			if (expensesByCategoryMap.containsKey(exp.getCategory())) {
				Double sum = expensesByCategoryMap.get(exp.getCategory());
				sum += exp.getAmount();
				//TODO: Probably references the same object
			
			} else {
				expensesByCategoryMap.put(exp.getCategory(), exp.getAmount());
			}
		}
		return expensesByCategoryMap;
	
	}

	@SuppressWarnings("unused")
	private double calculateExpensesTotal(List<Expense> expenses) {
		double sum = 0;

		for (Expense e : expenses) {
			sum += e.getAmount();
		}
		return sum;
	}

	@Override
	public List<ExpenseDTO> findExpensesByPlanForCategory(CriteriaDTO dto) throws ServiceProviderException {
		ExpenseDTOAssembler assembler = new ExpenseDTOAssembler();
		List<Expense> expensesList = null;
		try {
			expensesList = facade.findExpensesByPlanForCategory(dto.getCategoryAbbr(), dto.getMonth(), dto.getYear());
			
		} catch (Exception e) {
			logger.error("SubstituteSellerServiceImpl.findExpensesByPlanForCategory failed: ", e);
			throw new ServiceProviderException("SubstituteSellerServiceImpl.findExpensesByPlanForCategory ", e);			
		}
		
		return assembler.assembleDtoListFromExpensesList(expensesList);
		
	}

	@Override
	public Map<String, Double> findExpSumByBeneficiary(Month month, int year) throws ServiceProviderException {
		ExpenseDTOAssembler assembler = new ExpenseDTOAssembler();
		List<Expense> expensesList = null;

		try {
			expensesList = facade.findExpensesByPlanForBeneficiary(month, year);
			
		} catch (Exception e) {
			logger.error("SubstituteSellerServiceImpl.findExpSumByBeneficiary failed: ", e);
			throw new ServiceProviderException("SubstituteSellerServiceImpl.findExpSumByBeneficiary ", e);			
		}
		
		return assembler.assembleExpSumByBeneficiaries(expensesList);
		
	}
	
	// Spring setters
	//TODO: Maybe change to expenseService

//	public void setStatsConfig(StatsConfig statsConfig) {
//		this.statsConfig = statsConfig;
//	}
	
}
