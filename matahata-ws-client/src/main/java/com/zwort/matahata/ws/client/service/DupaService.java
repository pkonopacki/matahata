package com.zwort.matahata.ws.client.service;

import zwort.com.matahata.services._1.*;

public interface DupaService {
	
	FindExpensesByCategoriesResponse findExpensesByCategories(FindExpensesByCategories findExpensesByCategories);

	FindExpensesByPlanForCategoryResponse findExpensesByPlanForCategory(FindExpensesByPlanForCategory findExpensesByPlanForCategory);
	
	GetAccountStateResponse getAccountStates(GetAccountStateRequestList getAccountStateRequestList);

}
