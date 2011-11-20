package com.zwort.matahata.core.sp.ws.impl;

import zwort.com.matahata.services._1.DupaServicePortType;
import zwort.com.matahata.services._1.FindExpensesByCategories;
import zwort.com.matahata.services._1.FindExpensesByCategoriesResponse;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategory;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategoryResponse;

import com.zwort.matahata.core.sp.adapter.SubstituteSellerAdapter;

public class DupaServiceImpl implements DupaServicePortType {

	private SubstituteSellerAdapter substituteSellerAdapter;


	@Override
	public FindExpensesByCategoriesResponse findExpensesByCategories(
			FindExpensesByCategories findExpensesByCategories) {
		return substituteSellerAdapter.sellSubstitute(findExpensesByCategories);
	}

	@Override
	public FindExpensesByPlanForCategoryResponse findExpensesByPlanForCategory(
			FindExpensesByPlanForCategory findExpensesByPlanForCategory) {
		return substituteSellerAdapter.findExpensesByPlanForCategoryResponse(findExpensesByPlanForCategory);
	}

	//Spring setters
	
	public void setSubstituteSellerAdapter(
			SubstituteSellerAdapter substituteSellerAdapter) {
		this.substituteSellerAdapter = substituteSellerAdapter;
	}

}
