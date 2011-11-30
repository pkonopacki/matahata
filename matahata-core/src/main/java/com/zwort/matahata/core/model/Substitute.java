package com.zwort.matahata.core.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Substitute implements Serializable {
	
	private static final long serialVersionUID = -6737100786972458786L;

	private Plan plan;
	
	private Map<Category, Map<Currency, Double>> expensesByCategoriesMap;
	
	private Map<Currency, Double> totalsMap;
	
	private Set<BudgetUsageForCategory> budgetForCategoriesList;

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Map<Category, Map<Currency, Double>> getExpensesByCategoriesMap() {
		return expensesByCategoriesMap;
	}

	public void setExpensesByCategoriesMap(
			Map<Category, Map<Currency, Double>> expensesByCategoriesMap) {
		this.expensesByCategoriesMap = expensesByCategoriesMap;
	}

	public Map<Currency, Double> getTotalsMap() {
		return totalsMap;
	}

	public void setTotalsMap(Map<Currency, Double> totalsMap) {
		this.totalsMap = totalsMap;
	}

	public Set<BudgetUsageForCategory> getBudgetForCategoriesList() {
		
		if (budgetForCategoriesList == null) {
			budgetForCategoriesList = new HashSet<BudgetUsageForCategory>();
		}
		
		return budgetForCategoriesList;
	}

}
