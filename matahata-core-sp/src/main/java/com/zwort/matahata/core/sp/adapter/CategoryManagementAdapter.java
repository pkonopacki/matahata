package com.zwort.matahata.core.sp.adapter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.sp.ServiceLocator;
import com.zwort.matahata.core.sp.binder.CategoryRequestResponseBinder;
import com.zwort.matahata.core.sp.request.AddCategoryRequest;
import com.zwort.matahata.core.sp.response.AddCategoryResponse;
import com.zwort.matahata.core.sp.response.FindCategoryResponse;

public class CategoryManagementAdapter extends BaseAdapter {
	
	private static Log logger = LogFactory.getLog(CategoryManagementAdapter.class);
	
	public AddCategoryResponse addNewCategory(AddCategoryRequest request) {
	
		CategoryRequestResponseBinder binder = new CategoryRequestResponseBinder();
		AddCategoryResponse response = new AddCategoryResponse();
		
		try {
			binder.bindResponse(ServiceLocator.getInstance().getCategoryManagementService().addNewCategory(binder.bindCategoryDTOwithAddCategoryRequest(request)));
		
		} catch (Exception e) {
			logger.error("CategoryManagementAdapter.addNewCategory failed: ", e);
			response.setErrorMsg(e.getMessage());
		}
	
		return response;
	}
	
	public FindCategoryResponse findAllCategories(boolean active) {
	
		CategoryRequestResponseBinder binder = new CategoryRequestResponseBinder();
		FindCategoryResponse response = new FindCategoryResponse();
		
		try {
			response = binder.bindFindAllCategoryResponse(ServiceLocator.getInstance().getCategoryManagementService().findAllCategories(active));

		} catch (Exception e) {
			logger.error("CategoryManagementAdapter.addNewCategory failed: ", e);
			response.setErrorMsg(e.getMessage());
		}
		return response;

	}

}
