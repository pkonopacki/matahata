package com.zwort.matahata.ws.client.service.impl;

import javax.annotation.PostConstruct;

import zwort.com.matahata.services._1.DupaServicePortType;
import zwort.com.matahata.services._1.FindExpensesByCategories;
import zwort.com.matahata.services._1.FindExpensesByCategoriesResponse;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategory;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategoryResponse;
import zwort.com.matahata.services._1.GetAccountStateRequestList;
import zwort.com.matahata.services._1.GetAccountStateResponse;

import com.zwort.matahata.ws.client.DupaPortFactoryBean;
import com.zwort.matahata.ws.client.service.DupaService;

public class DupaServiceImpl implements DupaService {
	
	private DupaPortFactoryBean factory;

	private DupaServicePortType service;
	
	@PostConstruct
	public void init() {
		service = (DupaServicePortType) factory.create();
	}

	@Override
	public FindExpensesByCategoriesResponse findExpensesByCategories(
			FindExpensesByCategories findExpensesByCategories) {
		return service.findExpensesByCategories(findExpensesByCategories);
	}

	@Override
	public FindExpensesByPlanForCategoryResponse findExpensesByPlanForCategory(
			FindExpensesByPlanForCategory findExpensesByPlanForCategory) {
		return service.findExpensesByPlanForCategory(findExpensesByPlanForCategory);
	}

	@Override
	public GetAccountStateResponse getAccountStates(
			GetAccountStateRequestList getAccountStateRequestList) {
		return service.getAccountState(getAccountStateRequestList);
	}

	
	//Spring setters

	public void setFactory(DupaPortFactoryBean factory) {
		this.factory = factory;
	}

	public void setService(DupaServicePortType service) {
		this.service = service;
	}

}
