package com.zwort.matahata.core.sp.binder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import zwort.com.matahata.services._1.ExpenseWS;
import zwort.com.matahata.services._1.ExpensesByCategoriesWS;
import zwort.com.matahata.services._1.ExpensesByCategoriesWSList;
import zwort.com.matahata.services._1.ExpensesByCurrenciesWS;
import zwort.com.matahata.services._1.ExpensesTotalsByCategoriesWSMap;
import zwort.com.matahata.services._1.ExpensesTotalsByCurrenciesWS;
import zwort.com.matahata.services._1.ExpensesWSList;
import zwort.com.matahata.services._1.FindExpensesByCategoriesResponse;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategory;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategoryResponse;

import com.zwort.matahata.core.sp.dto.CategoryDTO;
import com.zwort.matahata.core.sp.dto.CriteriaDTO;
import com.zwort.matahata.core.sp.dto.CurrencyDTO;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;
import com.zwort.matahata.core.sp.dto.SubstituteDTO;
import com.zwort.matahata.core.sp.util.ConversionUtils;

public class SubstituteRequestResponseBinder extends BaseRequestResponseBinder {
	
	public FindExpensesByCategoriesResponse bindResponseFromDto(SubstituteDTO dto) {
		FindExpensesByCategoriesResponse response = new FindExpensesByCategoriesResponse();
		ExpensesByCategoriesWSList exByCategoriesWSList = new ExpensesByCategoriesWSList();
		ExpensesTotalsByCategoriesWSMap expTotalsByCurrWsMap = new ExpensesTotalsByCategoriesWSMap();
		
		List<ExpensesTotalsByCurrenciesWS> expensesTotalsByCurrWsList = bindExpensesTotalsByCurrencyList(dto.getTotalsByCurrMap());
		
		List<ExpensesByCategoriesWS> expensesByCategoriesWSList = bindExpenseByCategoriesList(dto.getExpensesByCatMap());
		
		exByCategoriesWSList.getExpensesByCategoriesWS().addAll(expensesByCategoriesWSList);
		response.setExpensesByCategoriesWSList(exByCategoriesWSList);
		
		expTotalsByCurrWsMap.getExpensesTotalsByCurrenciesWS().addAll(expensesTotalsByCurrWsList);
		response.setExpensesTotalsByCategoriesWSMap(expTotalsByCurrWsMap);
		
		return response;
	}
	
	public FindExpensesByPlanForCategoryResponse bindFindExpByPlanForCatResponseFromDtoList(List<ExpenseDTO> expenseDtoList) {
		FindExpensesByPlanForCategoryResponse response = new FindExpensesByPlanForCategoryResponse();
		ExpensesWSList expensesWSList = new ExpensesWSList();
		List<ExpenseWS> expenseWSsList = new ArrayList<ExpenseWS>();
		
		for (ExpenseDTO dto : expenseDtoList) {
			ExpenseWS expenseWS = bindExpenseWsFromDto(dto);
			expenseWSsList.add(expenseWS);
		}
		expensesWSList.getExpenseWS().addAll(expenseWSsList);
		response.setExpensesWSList(expensesWSList);
		
		return response;
	}


	private ExpenseWS bindExpenseWsFromDto(ExpenseDTO dto) {
		ExpenseWS expenseWS = new ExpenseWS();
		expenseWS.setAmount(dto.getAmount());
		expenseWS.setCategoryDesc(dto.getCategoryDesc());
		expenseWS.setDate(ConversionUtils.dateToXmlGregorianCalendar(dto.getDate()));
		expenseWS.setCurrencyIso(dto.getCurrencyIso());
		expenseWS.setOrigAmount(dto.getOriginalAmount());
		expenseWS.setOrigcurrIso(dto.getOriginalCurrencyISO());
		expenseWS.setLocation(dto.getLocation());
		expenseWS.setDescription(dto.getDescription());
		
		return expenseWS;
	}

	private List<ExpensesTotalsByCurrenciesWS> bindExpensesTotalsByCurrencyList(
			Map<CurrencyDTO, Double> totalsByCurrMap) {
		List<ExpensesTotalsByCurrenciesWS> expTotByCurrWsList = new ArrayList<ExpensesTotalsByCurrenciesWS>();
		
		Set<CurrencyDTO> keySet = totalsByCurrMap.keySet();
		
		for (CurrencyDTO dto : keySet) {
			ExpensesTotalsByCurrenciesWS expTotByCurrWs = bindExpensesTotalsByCurrenciesWs(dto, totalsByCurrMap.get(dto));
			expTotByCurrWsList.add(expTotByCurrWs);
		}
		
		return expTotByCurrWsList;
	}


	private ExpensesTotalsByCurrenciesWS bindExpensesTotalsByCurrenciesWs(
			CurrencyDTO dto, Double amount) {
		ExpensesTotalsByCurrenciesWS expTotalsByCurrenciesWS = new ExpensesTotalsByCurrenciesWS();
		expTotalsByCurrenciesWS.setCurrencyIso(dto.getCurrencyIsoCode());
		expTotalsByCurrenciesWS.setAmount(amount);
		return expTotalsByCurrenciesWS;
	}


	private List<ExpensesByCategoriesWS> bindExpenseByCategoriesList(
			Map<CategoryDTO, Map<CurrencyDTO, Double>> expensesByCatMap) {
		List<ExpensesByCategoriesWS> expensesByCategoriesWSList = new ArrayList<ExpensesByCategoriesWS>();
		
		Set<CategoryDTO> keyset = expensesByCatMap.keySet();
		
		for (CategoryDTO catDto : keyset) {
			ExpensesByCategoriesWS expByCatWS = bindExpensesByCategoriesWS(catDto, expensesByCatMap.get(catDto));
			expensesByCategoriesWSList.add(expByCatWS);
		}
		
		return expensesByCategoriesWSList;
	}

	private ExpensesByCategoriesWS bindExpensesByCategoriesWS(
			CategoryDTO catDto, Map<CurrencyDTO, Double> expByCurrMap) {
		ExpensesByCategoriesWS expByCatWS = new ExpensesByCategoriesWS();
		
		//TODO:Change this shit
		List<ExpensesByCurrenciesWS> expByCurrList = bindExpensesByCurrenciesWSList(expByCurrMap);
		expByCatWS.setCategoryAbbr(catDto.getAbbreviation());
		expByCatWS.getExpByCurrMap().addAll(expByCurrList);
		expByCatWS.setCategoryDesc(catDto.getDescription());

		return expByCatWS;
	}
	
	private List<ExpensesByCurrenciesWS> bindExpensesByCurrenciesWSList(
			Map<CurrencyDTO, Double> expByCurrMap) {
		List<ExpensesByCurrenciesWS> expByCurrWSList = new ArrayList<ExpensesByCurrenciesWS>();
		
		Set<CurrencyDTO> keySet = expByCurrMap.keySet();
		
		for (CurrencyDTO dto : keySet) {
			ExpensesByCurrenciesWS expByCurrWS = bindExpensesByCurrenciesWS(dto, expByCurrMap.get(dto));
			expByCurrWSList.add(expByCurrWS);
		}
		
		return expByCurrWSList;
	
	}

	private ExpensesByCurrenciesWS bindExpensesByCurrenciesWS(CurrencyDTO dto, Double amount) {
		ExpensesByCurrenciesWS expByCurrWS = new ExpensesByCurrenciesWS();
		expByCurrWS.setAmount(amount);
		expByCurrWS.setCurrencyIso(dto.getCurrencyIsoCode());
	
		return expByCurrWS;
	}

	public CriteriaDTO bindCriteriaDtoFromFindExpByPlanForCatRequest(FindExpensesByPlanForCategory request) {
		CriteriaDTO dto = new CriteriaDTO();
		dto.setCategoryAbbr(request.getCategoryAbbr());
		dto.setMonth(bindMonthFromWSMonth(request.getMonth()));
		
		return dto;
	}
	
}
