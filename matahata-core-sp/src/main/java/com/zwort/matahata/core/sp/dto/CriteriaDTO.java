package com.zwort.matahata.core.sp.dto;

import com.zwort.matahata.core.model.Month;

public class CriteriaDTO {
	
	private Month month;
	
	private int year;
	
	private String categoryAbbr;

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCategoryAbbr() {
		return categoryAbbr;
	}

	public void setCategoryAbbr(String categoryAbbr) {
		this.categoryAbbr = categoryAbbr;
	}
		
}
