package com.zwort.matahata.core.sp.binder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zwort.com.matahata.services._1.BudgetUsageByCategoriesWS;
import zwort.com.matahata.services._1.BudgetUsageByCategoriesWSList;
import zwort.com.matahata.services._1.BudgetUsageTotalsWS;
import zwort.com.matahata.services._1.ExpenseWS;
import zwort.com.matahata.services._1.ExpensesByBenWS;
import zwort.com.matahata.services._1.ExpensesByCategoriesWS;
import zwort.com.matahata.services._1.ExpensesByCategoriesWSList;
import zwort.com.matahata.services._1.ExpensesByCurrenciesWS;
import zwort.com.matahata.services._1.ExpensesTotalsByCategoriesWSMap;
import zwort.com.matahata.services._1.ExpensesTotalsByCurrenciesWS;
import zwort.com.matahata.services._1.ExpensesWSList;
import zwort.com.matahata.services._1.FindExpensesByBeneficiaries;
import zwort.com.matahata.services._1.FindExpensesByBeneficiariesList;
import zwort.com.matahata.services._1.FindExpensesByBeneficiariesResp;
import zwort.com.matahata.services._1.FindExpensesByCategoriesResponse;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategory;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategoryResponse;

import com.zwort.matahata.core.sp.assembler.SubstituteDtoAssembler;
import com.zwort.matahata.core.sp.dto.BudgetUsageDTO;
import com.zwort.matahata.core.sp.dto.CategoryDTO;
import com.zwort.matahata.core.sp.dto.CategoryType;
import com.zwort.matahata.core.sp.dto.CriteriaDTO;
import com.zwort.matahata.core.sp.dto.CurrencyDTO;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;
import com.zwort.matahata.core.sp.dto.SubstituteDTO;
import com.zwort.matahata.core.sp.util.ConversionUtils;

public class SubstituteRequestResponseBinder extends BaseRequestResponseBinder {
	
	private static final Log logger = LogFactory.getLog(SubstituteDtoAssembler.class);
	
	public FindExpensesByCategoriesResponse bindResponseFromDto(SubstituteDTO dto) {
		FindExpensesByCategoriesResponse response = new FindExpensesByCategoriesResponse();
		ExpensesByCategoriesWSList exByCategoriesWSList = new ExpensesByCategoriesWSList();
		ExpensesTotalsByCategoriesWSMap expTotalsByCurrWsMap = new ExpensesTotalsByCategoriesWSMap();
		BudgetUsageByCategoriesWSList budgetUsageForCategoriesWSList = new BudgetUsageByCategoriesWSList();
		
		List<ExpensesTotalsByCurrenciesWS> expensesTotalsByCurrWsList = bindExpensesTotalsByCurrencyList(dto.getTotalsByCurrMap());
		
		//List<ExpensesByCategoriesWS> expensesByCategoriesWSList = bindExpenseByCategoriesList(dto.getExpensesByCatMap());
		
		Set<BudgetUsageByCategoriesWS> budgetUsageByCatList = bindBudgetUsageByCatList(dto.getBudgetUsageList());
		
		//BudgetUsageTotalsWS budgetUsageTotalsWS = bindBudgetUsageTotalsWS(dto.getBudgetUsageList());
		BudgetUsageTotalsWS budgetUsageTotalsWS = new BudgetUsageTotalsWS();
		
		budgetUsageForCategoriesWSList.getBudgetUsageByCategoriesWS().addAll(budgetUsageByCatList);
		response.setBudgetUsageByCategoriesWSList(budgetUsageForCategoriesWSList);
		
		Collections.sort(response.getBudgetUsageByCategoriesWSList().getBudgetUsageByCategoriesWS(), new BudgetUsageByCategoriesWSComparable());

		//exByCategoriesWSList.getExpensesByCategoriesWS().addAll(expensesByCategoriesWSList);
		response.setExpensesByCategoriesWSList(exByCategoriesWSList);
		
		expTotalsByCurrWsMap.getExpensesTotalsByCurrenciesWS().addAll(expensesTotalsByCurrWsList);
		response.setExpensesTotalsByCategoriesWSMap(expTotalsByCurrWsMap);
		
		response.setBudgetUsageTotalsWS(budgetUsageTotalsWS);
		
		return response;
	}
	
	private BudgetUsageTotalsWS bindBudgetUsageTotalsWS(
			Set<BudgetUsageDTO> budgetUsageList) {
		BudgetUsageTotalsWS budgetUsageTotalsWS = new BudgetUsageTotalsWS();
		Double budgetIncomesPlanned = new Double(0);
		Double budgetExpensesPlanned = new Double(0);
		Double budgetIncomesReal = new Double(0);
		Double budgetExpensesReal = new Double(0);
		
		for (BudgetUsageDTO dto : budgetUsageList) {
			logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS BudgetUsageDTO: " + dto.getCategoryAbbr() + ", " + dto.getCategoryType().toString() + ", " + dto.getBudgetAmount() + ", " + dto.getUsedAmount());

			if (dto.getCategoryType().equals(CategoryType.EXPENSE)) {
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS EXPENSE");
				budgetExpensesPlanned += dto.getBudgetAmount();
				budgetExpensesReal += dto.getUsedAmount();
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetIncomesPlanned cat" + dto.getCategoryAbbr());
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetExpensesPlanned adding dto.getBudgetAmount(): " + dto.getBudgetAmount());
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetExpensesPlanned after addition: " + budgetExpensesPlanned);
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetExpensesPlanned adding dto.getUsedAmount(): " + dto.getUsedAmount());
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetExpensesPlanned after addition: " + budgetExpensesReal);
				
			} else {
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS INCOME");
				budgetIncomesPlanned += dto.getBudgetAmount();
				budgetIncomesReal += dto.getUsedAmount();
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetIncomesPlanned cat" + dto.getCategoryAbbr());
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetIncomesPlanned adding dto.getBudgetAmount(): " + dto.getBudgetAmount());
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetIncomesPlanned after addition: " + budgetIncomesPlanned);
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetIncomesReal adding dto.getUsedAmount(): " + dto.getUsedAmount());
				logger.debug("SubstituteRequestResponseBinder#bindBudgetUsageTotalsWS budgetIncomesReal after addition: " + budgetIncomesReal);
			}
		}
		
		budgetUsageTotalsWS.setBudgetExpenseTotals(budgetExpensesPlanned);
		budgetUsageTotalsWS.setBudgeExpensetUsed(budgetExpensesReal);
		budgetUsageTotalsWS.setBudgeExpenseDeff(budgetExpensesPlanned - budgetExpensesReal);
		
		budgetUsageTotalsWS.setBudgetIncomeTotals(budgetIncomesPlanned);
		budgetUsageTotalsWS.setBudgetIncomeUsed(budgetIncomesReal);
		budgetUsageTotalsWS.setBudgetIncomeDeff(budgetIncomesPlanned - budgetIncomesReal);
		
		return budgetUsageTotalsWS;
	}

	private Set<BudgetUsageByCategoriesWS> bindBudgetUsageByCatList(
			Set<BudgetUsageDTO> budgetUsageList) {
		Set<BudgetUsageByCategoriesWS> budgetUsageByCatWSList = new HashSet<BudgetUsageByCategoriesWS>();
		
		for (BudgetUsageDTO dto : budgetUsageList) {
			
			if (dto.getUsedAmount() != 0) {
				BudgetUsageByCategoriesWS budUsByCatWS = assembleBudgetUsageByCatWS(dto);
				budgetUsageByCatWSList.add(budUsByCatWS);
			}
		}
		
		return budgetUsageByCatWSList;
	
	}

	private BudgetUsageByCategoriesWS assembleBudgetUsageByCatWS(
			BudgetUsageDTO dto) {
		BudgetUsageByCategoriesWS budgetUsageByCatWS = new BudgetUsageByCategoriesWS();
		
		DecimalFormat df = new DecimalFormat("###.00");

		budgetUsageByCatWS.setCategoryDesc(dto.getCategoryDesc());
		budgetUsageByCatWS.setCategoryAbbr(dto.getCategoryAbbr());
		budgetUsageByCatWS.setBudgetAmount(dto.getBudgetAmount());
		budgetUsageByCatWS.setAmountUsed(new Double(df.format(dto.getUsedAmount())));
		
		return budgetUsageByCatWS;
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
		dto.setYear(request.getYear());
		
		return dto;
	}
	
	public CriteriaDTO bindCriteriaDtoFromFindExpByBeneficiariesRequest(FindExpensesByBeneficiaries request) {
		CriteriaDTO dto = new CriteriaDTO();
		dto.setCategoryAbbr(request.getCategoryAbbr());
		dto.setMonth(bindMonthFromWSMonth(request.getMonth()));
		dto.setYear(request.getYear());
		
		return dto;
	}

	public FindExpensesByBeneficiariesResp bindFindExpensesByBeneficiariesResp(Map<String, Double> expenseByBenMap) {
		FindExpensesByBeneficiariesResp response = new FindExpensesByBeneficiariesResp();
		FindExpensesByBeneficiariesList expByBenList = new FindExpensesByBeneficiariesList();
		List<ExpensesByBenWS> expByBenWSList = new ArrayList<ExpensesByBenWS>();
		Set<String> keySet = expenseByBenMap.keySet();
		
		for (String key : keySet) {
			ExpensesByBenWS expensesByBenWS = new ExpensesByBenWS();
			expensesByBenWS.setBen(key);
			expensesByBenWS.setAmount(expenseByBenMap.get(key));
			expByBenWSList.add(expensesByBenWS);
		}
		expByBenList.getExpensesByBenWS().addAll(expByBenWSList);
		response.setFindExpensesByBeneficiariesList(expByBenList);
		
		return response;
	}
	
	public List<String> bindInitialListFromRequest(FindExpensesByBeneficiaries findExpensesByBeneficiaries) {
		List<String> returnList = new ArrayList<String>();
		
		//TODO: Implement this crap
		
		return returnList;
	}
	
}
