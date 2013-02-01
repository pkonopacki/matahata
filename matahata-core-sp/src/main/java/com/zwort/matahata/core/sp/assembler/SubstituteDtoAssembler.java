package com.zwort.matahata.core.sp.assembler;

import com.zwort.matahata.core.model.*;
import com.zwort.matahata.core.sp.dto.*;
import com.zwort.matahata.core.sp.dto.CategoryType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstituteDtoAssembler {
	
	private static final Log logger = LogFactory.getLog(SubstituteDtoAssembler.class);

	public SubstituteDTO assembleSubstitute(Substitute substitute) {
		logger.debug("SubstituteDtoAssembler#assembleSubstitute start");
		logger.debug("SubstituteDtoAssembler#assembleSubstitute substitute.expensesByCategoriesMap.size(): " + substitute.getExpensesByCategoriesMap().size());
		
		SubstituteDTO dto = new SubstituteDTO();
		Map<CategoryDTO, Map<CurrencyDTO, Double>> expByCatDtoMap = assembleExpensesByCatMap(substitute.getExpensesByCategoriesMap());

		PlanDTO planDto = assemblePlan(substitute.getPlan());
		dto.setExpensesByCatMap(expByCatDtoMap);
		dto.setPlan(planDto);
		
		Map<CurrencyDTO, Double> totalsByCurrDtoMap = assembleExpensesByCurrencyDtoMap(substitute.getTotalsMap());
		Set<BudgetUsageDTO> budgetUsageDtoList = assembleBudgetUsageDtoList(substitute.getBudgetForCategoriesList());
		
		dto.getBudgetUsageList().addAll(budgetUsageDtoList);

		for (BudgetUsageDTO dtoLog : dto.getBudgetUsageList()) {
			logger.debug("SubstituteDtoAssembler#assembleSubstitute BudgetUsageDTO: " + dtoLog.getCategoryAbbr() + ", " + dtoLog.getBudgetAmount() + ", " + dtoLog.getUsedAmount());
		}
		
		dto.setTotalsByCurrMap(totalsByCurrDtoMap);
		logger.debug("SubstituteDtoAssembler#assembleSubstitute end");
		
		return dto;
	}

	private Set<BudgetUsageDTO> assembleBudgetUsageDtoList(
			Set<BudgetUsageForCategory> budgetForCategoriesList) {
		logger.debug("SubstituteDtoAssembler#assembleBudgetUsageDtoList start");
		logger.debug("SubstituteDtoAssembler#assembleBudgetUsageDtoList budgetForCategoriesList.size: " + budgetForCategoriesList.size());
		
		Set<BudgetUsageDTO> budgetUsageDtoList = new HashSet<BudgetUsageDTO>();
		
		for (BudgetUsageForCategory budgetUsage : budgetForCategoriesList) {
			BudgetUsageDTO dto = assembleBudgetUsageDTO(budgetUsage);
			budgetUsageDtoList.add(dto);
		}
		
		logger.debug("SubstituteDtoAssembler#assembleBudgetUsageDtoList end");
		return budgetUsageDtoList;
	}

	private BudgetUsageDTO assembleBudgetUsageDTO(
			BudgetUsageForCategory budgetUsage) {
		BudgetUsageDTO dto = new BudgetUsageDTO();
		dto.setCategoryAbbr(budgetUsage.getCategory().getAbbreviation());
		dto.setCategoryDesc(budgetUsage.getCategory().getDescription());
		dto.setBudgetAmount(budgetUsage.getBudgetAmount());
		dto.setUsedAmount(budgetUsage.getSpentTillNow());
		
		dto.setCategoryType(budgetUsage.getCategory().getCategoryType().equals(com.zwort.matahata.core.model.CategoryType.INCOME) ? CategoryType.INCOME : CategoryType.EXPENSE);
		logger.debug("SubstituteDtoAssembler#assembleBudgetUsageDTO CategoryType for cat [" + budgetUsage.getCategory().getAbbreviation() + "]: " + budgetUsage.getCategory().getCategoryType().toString());
		return dto;
	}

	private PlanDTO assemblePlan(Plan plan) {
		PlanDTOAssembler planDtoAssembler = new PlanDTOAssembler();
		return planDtoAssembler.assemblePlanDto(plan);
	}

//	private Map<CategoryDTO, Double> assembleExpensesByCatMap(
//			Map<Category, Double> expensesByCategoriesMap) {
//		Map<CategoryDTO, Double> expByCatDtoMap = new HashMap<CategoryDTO, Double>();
//		CategoryDTOAssembler categoryDTOAssembler = new CategoryDTOAssembler();
//		
//		Set<Category> categoriesOnMap = expensesByCategoriesMap.keySet();
//		
//		for (Category cat : categoriesOnMap) {
//			CategoryDTO categoryDto = categoryDTOAssembler.categoryToDto(cat);
//			expByCatDtoMap.put(categoryDto, expensesByCategoriesMap.get(cat));
//		}
//		return expByCatDtoMap; 
//	}
	
	private Map<CategoryDTO, Map<CurrencyDTO, Double>> assembleExpensesByCatMap(Map<Category, Map<Currency, Double>> expensesByCategoriesMap) {
		logger.debug("SubstituteDtoAssembler#assembleExpensesByCatMap start");
		logger.debug("SubstituteDtoAssembler#assembleExpensesByCatMap expensesByCategoriesMap.size(): " + expensesByCategoriesMap.size());
		Map<CategoryDTO, Map<CurrencyDTO, Double>> expByCatDtoMap = new HashMap<CategoryDTO, Map<CurrencyDTO, Double>>();
		CategoryDTOAssembler categoryDTOAssembler = new CategoryDTOAssembler();
		
		Set<Category> categoriesOnMap = expensesByCategoriesMap.keySet();
		
		for (Category cat : categoriesOnMap) {
			CategoryDTO categoryDto = categoryDTOAssembler.categoryToDto(cat);
			Map<CurrencyDTO, Double> expByCurrMap = assembleExpensesByCurrencyDtoMap(expensesByCategoriesMap.get(cat));
			expByCatDtoMap.put(categoryDto, expByCurrMap);
			
		}
		
		logger.debug("SubstituteDtoAssembler#assembleExpensesByCatMap expByCatDtoMap.size(): " + expByCatDtoMap.size());
		logger.debug("SubstituteDtoAssembler#assembleExpensesByCatMap start");
		return expByCatDtoMap; 
	}
	
	private Map<CurrencyDTO, Double> assembleExpensesByCurrencyDtoMap(Map<Currency, Double> expByCurrMap) {
		logger.debug("SubstituteDtoAssembler#assembleExpensesByCurrencyDtoMap start");
		Map<CurrencyDTO, Double> expensesByCurrencyDtoMap = new HashMap<CurrencyDTO, Double>();
		CurrencyDtoAssembler currAssembler = new CurrencyDtoAssembler();
		logger.debug("SubstituteDtoAssembler#assembleExpensesByCurrencyDtoMap expByCurrMap.size(): " + expByCurrMap.size());
		
		Set<Currency> keySet = expByCurrMap.keySet();
		
		for (Currency currency : keySet) {
			CurrencyDTO dto = currAssembler.currencyToDto(currency);
			expensesByCurrencyDtoMap.put(dto, expByCurrMap.get(currency));
		}

		logger.debug("SubstituteDtoAssembler#assembleExpensesByCurrencyDtoMap expByCatDtoMap.size(): " + expensesByCurrencyDtoMap.size());
		logger.debug("SubstituteDtoAssembler#assembleExpensesByCurrencyDtoMap start");
		return expensesByCurrencyDtoMap;
	}

}