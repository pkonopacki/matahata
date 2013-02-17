package com.zwort.matahata.ws.client.service.impl;

import com.zwort.matahata.ws.client.DupaPortFactoryBean;
import com.zwort.matahata.ws.client.service.DupaService;
import zwort.com.matahata.services._1.*;

import javax.annotation.PostConstruct;

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
