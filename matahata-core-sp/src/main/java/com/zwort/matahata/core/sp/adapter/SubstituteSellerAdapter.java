package com.zwort.matahata.core.sp.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import zwort.com.matahata.services._1.FindExpensesByCategories;
import zwort.com.matahata.services._1.FindExpensesByCategoriesResponse;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategory;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategoryResponse;

import com.zwort.matahata.core.sp.ServiceLocator;
import com.zwort.matahata.core.sp.binder.SubstituteRequestResponseBinder;
import com.zwort.matahata.core.sp.exception.util.ErrorPropertiesUtils;

public class SubstituteSellerAdapter {

	private static Log logger = LogFactory.getLog(SubstituteSellerAdapter.class);
	
	public FindExpensesByCategoriesResponse sellSubstitute(FindExpensesByCategories request) {
		logger.debug("SubstituteSellerAdapter#sellSubstitute start");
		SubstituteRequestResponseBinder binder = new SubstituteRequestResponseBinder();
		FindExpensesByCategoriesResponse response = new FindExpensesByCategoriesResponse();
		
		try {
			response = binder.bindResponseFromDto(ServiceLocator.getInstance().getSubstituteSellerService().sellSubstitute(binder.bindMonthFromWSMonth(request.getMonth())));
		
		} catch (Exception e) {
			logger.error("SubstituteSellerAdapter.sellSubstitute failed: ", e);
			response = (FindExpensesByCategoriesResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "SubstituteSellerAdapter.sellSubstitute failed: ");
		}
		logger.debug("SubstituteSellerAdapter#sellSubstitute returning response: " + response);
		logger.debug("SubstituteSellerAdapter#sellSubstitute end");
		return response;
	
	}

	public FindExpensesByPlanForCategoryResponse findExpensesByPlanForCategoryResponse(FindExpensesByPlanForCategory request) {
		logger.debug("SubstituteSellerAdapter#sellSubstitute start");
		SubstituteRequestResponseBinder binder = new SubstituteRequestResponseBinder();
		FindExpensesByPlanForCategoryResponse response = new FindExpensesByPlanForCategoryResponse();
		
		try {
			response = binder.bindFindExpByPlanForCatResponseFromDtoList(ServiceLocator.getInstance().getSubstituteSellerService().findExpensesByPlanForCategory(binder.bindCriteriaDtoFromFindExpByPlanForCatRequest(request)));
		
		} catch (Exception e) {
			logger.error("SubstituteSellerAdapter.sellSubstitute failed: ", e);
			response = (FindExpensesByPlanForCategoryResponse) ErrorPropertiesUtils.setErrorInfo(response, e, "SubstituteSellerAdapter.sellSubstitute failed: ");
		}
		logger.debug("SubstituteSellerAdapter#sellSubstitute returning response: " + response);
		logger.debug("SubstituteSellerAdapter#sellSubstitute end");
		return response;
	
	}

}
