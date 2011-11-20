package com.zwort.matahata.core.sp.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zwort.com.matahata.services._1.AddIncomeRequestList;
import zwort.com.matahata.services._1.AddIncomeResponseList;

import com.zwort.matahata.core.sp.ServiceLocator;
import com.zwort.matahata.core.sp.binder.IncomeRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;

public class IncomeManagementAdapter {

	private static Log logger = LogFactory.getLog(IncomeManagementAdapter.class);
	
	public AddIncomeResponseList addNewIncome(AddIncomeRequestList request) {
		IncomeRequestResponseBinder binder = new IncomeRequestResponseBinder();
		AddIncomeResponseList response = new AddIncomeResponseList();
		
		try {
			response = binder.bindAddIncomeResponseList(ServiceLocator.getInstance().getIncomeManagementService().addNewIncome(binder.bindIncomeDtoListFromAddIncomeRequest(request)));
		
		} catch (Exception e) {
			logger.error("IncomeManagementAdapter.addNewIncome failed: ", e);
			response = (AddIncomeResponseList) ErrorPropertiesUtils.setErrorInfo(response, e, "IncomeManagementAdapter.addNewIncome failed: ");
		}
		return response;
	}
	
}
