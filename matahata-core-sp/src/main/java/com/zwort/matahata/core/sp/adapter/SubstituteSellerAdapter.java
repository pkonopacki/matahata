package com.zwort.matahata.core.sp.adapter;

import com.zwort.matahata.core.sp.binder.SubstituteRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;
import com.zwort.matahata.core.sp.service.SubstituteSellerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.*;

import javax.inject.Inject;

@Component
public class SubstituteSellerAdapter {

    @Inject
    private SubstituteSellerService substituteSellerService;

	private static Log logger = LogFactory.getLog(SubstituteSellerAdapter.class);
	
	public FindExpensesByCategoriesResponse sellSubstitute(FindExpensesByCategories request) {
		logger.debug("SubstituteSellerAdapter#sellSubstitute start");
		SubstituteRequestResponseBinder binder = new SubstituteRequestResponseBinder();
		FindExpensesByCategoriesResponse response = new FindExpensesByCategoriesResponse();
		
		try {
			response = binder.bindResponseFromDto(substituteSellerService.sellSubstitute(binder.bindMonthFromWSMonth(request.getMonth()), request.getYear()));
		
		} catch (Exception e) {
			logger.error("SubstituteSellerAdapter.sellSubstitute failed: ", e);
			response = (FindExpensesByCategoriesResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "SubstituteSellerAdapter.sellSubstitute failed: ");
		}
		logger.debug("SubstituteSellerAdapter#sellSubstitute returning response: " + response);
		logger.debug("SubstituteSellerAdapter#sellSubstitute end");
		return response;
	
	}

	public FindExpensesByPlanForCategoryResponse findExpensesByPlanForCategoryResponse(FindExpensesByPlanForCategory request) {
		logger.debug("SubstituteSellerAdapter#findExpensesByPlanForCategoryResponse start");
		SubstituteRequestResponseBinder binder = new SubstituteRequestResponseBinder();
		FindExpensesByPlanForCategoryResponse response = new FindExpensesByPlanForCategoryResponse();
		
		try {
			response = binder.bindFindExpByPlanForCatResponseFromDtoList(substituteSellerService.findExpensesByPlanForCategory(binder.bindCriteriaDtoFromFindExpByPlanForCatRequest(request)));
		
		} catch (Exception e) {
			logger.error("SubstituteSellerAdapter.findExpensesByPlanForCategoryResponse failed: ", e);
			response = (FindExpensesByPlanForCategoryResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "SubstituteSellerAdapter.findExpensesByPlanForCategoryResponse failed: ");
		}
		logger.debug("SubstituteSellerAdapter#findExpensesByPlanForCategoryResponse returning response: " + response);
		logger.debug("SubstituteSellerAdapter#findExpensesByPlanForCategoryResponse end");
		return response;
	
	}
	
	public FindExpensesByBeneficiariesResp findExpensesByBeneficiaries(FindExpensesByBeneficiaries request) {
		logger.debug("SubstituteSellerAdapter#findExpensesByBeneficiaries start");
		FindExpensesByBeneficiariesResp response = new FindExpensesByBeneficiariesResp();
		SubstituteRequestResponseBinder binder = new SubstituteRequestResponseBinder();
		
		try {
			response = binder.bindFindExpensesByBeneficiariesResp(substituteSellerService.findExpSumByBeneficiary(binder.bindMonthFromWSMonth(request.getMonth()), request.getYear()));
			
		} catch (Exception e) {
			logger.error("SubstituteSellerAdapter.findExpensesByBeneficiaries failed: ", e);
			response = (FindExpensesByBeneficiariesResp) ErrorPropertiesUtils.setErrorInfo(response, e, "SubstituteSellerAdapter.findExpensesByBeneficiaries failed: ");
		}
		logger.debug("SubstituteSellerAdapter#findExpensesByBeneficiaries returning response: " + response);
		logger.debug("SubstituteSellerAdapter#findExpensesByBeneficiaries end");
		return response;
		
	}

}
