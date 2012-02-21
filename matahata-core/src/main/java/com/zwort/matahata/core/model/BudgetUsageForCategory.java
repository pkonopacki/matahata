package com.zwort.matahata.core.model;


public class BudgetUsageForCategory {
	
	private Category category;
	
	private Double budgetAmount;
	
	private Double spentTillNow;

	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getBudgetAmount() {
		return budgetAmount;
	}

	public void setBudgetAmount(Double budgetAmount) {
		this.budgetAmount = budgetAmount;
	}

	public Double getSpentTillNow() {
		return spentTillNow;
	}

	public void setSpentTillNow(Double spentTillNow) {
		this.spentTillNow = spentTillNow;
	}
	
}