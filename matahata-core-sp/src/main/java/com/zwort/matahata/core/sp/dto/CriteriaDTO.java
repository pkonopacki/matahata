package com.zwort.matahata.core.sp.dto;

import com.zwort.matahata.core.model.Month;

public class CriteriaDTO {
	
	private Month month;
	
	private String categoryAbbr;

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public String getCategoryAbbr() {
		return categoryAbbr;
	}

	public void setCategoryAbbr(String categoryAbbr) {
		this.categoryAbbr = categoryAbbr;
	}
		
}
