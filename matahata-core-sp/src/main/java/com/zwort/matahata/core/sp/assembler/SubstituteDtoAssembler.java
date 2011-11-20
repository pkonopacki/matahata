package com.zwort.matahata.core.sp.assembler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.Substitute;
import com.zwort.matahata.core.sp.dto.CategoryDTO;
import com.zwort.matahata.core.sp.dto.CurrencyDTO;
import com.zwort.matahata.core.sp.dto.PlanDTO;
import com.zwort.matahata.core.sp.dto.SubstituteDTO;

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
		dto.setTotalsByCurrMap(totalsByCurrDtoMap);
		logger.debug("SubstituteDtoAssembler#assembleSubstitute end");
		
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
