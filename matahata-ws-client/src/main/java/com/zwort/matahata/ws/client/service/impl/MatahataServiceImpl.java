package com.zwort.matahata.ws.client.service.impl;

import javax.annotation.PostConstruct;

import zwort.com.matahata.services._1.AddExpenseRequestsList;
import zwort.com.matahata.services._1.AddExpenseResponseList;
import zwort.com.matahata.services._1.AddIncomeRequestList;
import zwort.com.matahata.services._1.AddIncomeResponseList;
import zwort.com.matahata.services._1.AddPlanRequest;
import zwort.com.matahata.services._1.AddPlanResponse;
import zwort.com.matahata.services._1.AddTransferRequestList;
import zwort.com.matahata.services._1.AddTransferResponseList;
import zwort.com.matahata.services._1.MatahataServicePortType;

import com.zwort.matahata.ws.client.MatahataPortFactoryBean;
import com.zwort.matahata.ws.client.service.MatahataService;

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
