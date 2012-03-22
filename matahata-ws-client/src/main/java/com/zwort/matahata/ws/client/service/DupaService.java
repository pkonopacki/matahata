package com.zwort.matahata.ws.client.service;

import zwort.com.matahata.services._1.FindExpensesByCategories;
import zwort.com.matahata.services._1.FindExpensesByCategoriesResponse;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategory;
import zwort.com.matahata.services._1.FindExpensesByPlanForCategoryResponse;
import zwort.com.matahata.services._1.GetAccountStateRequestList;
import zwort.com.matahata.services._1.GetAccountStateResponse;

public interface DupaService {
	
	FindExpensesByCategoriesResponse findExpensesByCategories(FindExpensesByCategories findExpensesByCategories);

	FindExpensesByPlanForCategoryResponse findExpensesByPlanForCategory(FindExpensesByPlanForCategory findExpensesByPlanForCategory);
	
	GetAccountStateResponse getAccountStates(GetAccountStateRequestList getAccountStateRequestList);

}
