package com.zwort.matahata.core.sp.dto;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstituteDTO {
	
	private Map<CurrencyDTO, Double> totalsByCurrMap;
	
	private PlanDTO plan;
	
	private Map<CategoryDTO, Map<CurrencyDTO, Double>> expensesByCatMap;
	
	private Set<BudgetUsageDTO> budgetUsageList;


	public Map<CurrencyDTO, Double> getTotalsByCurrMap() {
		return totalsByCurrMap;
	}

	public void setTotalsByCurrMap(Map<CurrencyDTO, Double> totalsByCurrMap) {
		this.totalsByCurrMap = totalsByCurrMap;
	}

	public PlanDTO getPlan() {
		return plan;
	}

	public void setPlan(PlanDTO plan) {
		this.plan = plan;
	}

	public Map<CategoryDTO, Map<CurrencyDTO, Double>> getExpensesByCatMap() {
		return expensesByCatMap;
	}

	public void setExpensesByCatMap(
			Map<CategoryDTO, Map<CurrencyDTO, Double>> expensesByCatMap) {
		this.expensesByCatMap = expensesByCatMap;
	}

	public Set<BudgetUsageDTO> getBudgetUsageList() {
		
		if (budgetUsageList == null) {
			budgetUsageList = new HashSet<BudgetUsageDTO>();
		}
		
		return budgetUsageList;
	}

}
