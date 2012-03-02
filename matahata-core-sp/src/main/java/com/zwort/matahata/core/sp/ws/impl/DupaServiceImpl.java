package com.zwort.matahata.core.sp.ws.impl;

import zwort.com.matahata.services._1.DupaServicePortType;
import zwort.com.matahata.services._1.FindExpensesByCategories;
import zwort.com.matahata.services._1.FindExpensesByCategoriesResponse;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategory;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategoryResponse;
import zwort.com.matahata.services._1.GetAccountStateRequestList;
import zwort.com.matahata.services._1.GetAccountStateResponse;

import com.zwort.matahata.core.sp.adapter.AccountManagementAdapter;
import com.zwort.matahata.core.sp.adapter.SubstituteSellerAdapter;

public class DupaServiceImpl implements DupaServicePortType {

	private SubstituteSellerAdapter substituteSellerAdapter;
	private AccountManagementAdapter accountManagementAdapter;


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

	@Override
	public GetAccountStateResponse getAccountState(
			GetAccountStateRequestList getAccountState) {
		return accountManagementAdapter.getAccountState(getAccountState);
	}
	
	//Spring setters
	
	public void setSubstituteSellerAdapter(
			SubstituteSellerAdapter substituteSellerAdapter) {
		this.substituteSellerAdapter = substituteSellerAdapter;
	}

	public void setAccountManagementAdapter(
			AccountManagementAdapter accountManagementAdapter) {
		this.accountManagementAdapter = accountManagementAdapter;
	}

}
