package com.zwort.matahata.core.sp.adapter;

import com.zwort.matahata.core.sp.binder.IncomeRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;
import com.zwort.matahata.core.sp.service.IncomeManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.AddIncomeRequestList;
import zwort.com.matahata.services._1.AddIncomeResponseList;

import javax.inject.Inject;

@Component
public class IncomeManagementAdapter {

	@Inject
    private IncomeManagementService incomeManagementService;

    private static Log logger = LogFactory.getLog(IncomeManagementAdapter.class);
	
	public AddIncomeResponseList addNewIncome(AddIncomeRequestList request) {
		IncomeRequestResponseBinder binder = new IncomeRequestResponseBinder();
		AddIncomeResponseList response = new AddIncomeResponseList();
		
		try {
			response = binder.bindAddIncomeResponseList(incomeManagementService.addNewIncome(binder.bindIncomeDtoListFromAddIncomeRequest(request)));
		
		} catch (Exception e) {
			logger.error("IncomeManagementAdapter.addNewIncome failed: ", e);
			response = (AddIncomeResponseList) ErrorPropertiesUtils.setErrorInfo(response, e, "IncomeManagementAdapter.addNewIncome failed: ");
		}
		return response;
	}
	
}
