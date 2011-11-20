package com.zwort.matahata.core.sp.dto;

public class PlanItemDTO extends BaseDTO {
	
	private String categoryAbbr;
	
	private Double catLimit;

	public String getCategoryAbbr() {
		return categoryAbbr;
	}

	public void setCategoryAbbr(String categoryAbbr) {
		this.categoryAbbr = categoryAbbr;
	}

	public Double getCatLimit() {
		return catLimit;
	}

	public void setCatLimit(Double catLimit) {
		this.catLimit = catLimit;
	}
	
}
