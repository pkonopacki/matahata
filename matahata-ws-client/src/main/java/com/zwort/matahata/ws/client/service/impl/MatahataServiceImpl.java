package com.zwort.matahata.ws.client.service.impl;

import com.zwort.matahata.ws.client.MatahataPortFactoryBean;
import com.zwort.matahata.ws.client.service.MatahataService;
import zwort.com.matahata.services._1.*;

import javax.annotation.PostConstruct;

public class MatahataServiceImpl implements MatahataService {

	private MatahataPortFactoryBean factory;
	
	private MatahataServicePortType service;
	
	@PostConstruct
	public void init() {
		service = (MatahataServicePortType) factory.create();
	}
	
	@Override
	public AddTransferResponseList addNewTransfer(AddTransferRequestList request) {
		return service.addNewTransfer(request);
	}

	@Override
	public AddIncomeResponseList addNewIncome(AddIncomeRequestList request) {
		return service.addNewIncome(request);
	}

	@Override
	public AddExpenseResponseList addNewExpense(AddExpenseRequestsList request) {
		return service.addNewExpense(request);
	}

	@Override
	public AddPlanResponse addNewPlan(AddPlanRequest request) {
		return service.addNewPlan(request);
	}

	
	//Spring setters

	public void setFactory(MatahataPortFactoryBean factory) {
		this.factory = factory;
	}

}
