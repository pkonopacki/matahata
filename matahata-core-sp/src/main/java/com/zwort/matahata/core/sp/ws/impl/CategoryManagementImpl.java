package com.zwort.matahata.core.sp.ws.impl;

import javax.jws.WebService;

import com.zwort.matahata.core.sp.adapter.CategoryManagementAdapter;
import com.zwort.matahata.core.sp.request.AddCategoryRequest;
import com.zwort.matahata.core.sp.response.FindCategoryResponse;
import com.zwort.matahata.core.sp.response.ResponseBase;
import com.zwort.matahata.core.sp.ws.CategoryManagement;

@WebService
public class CategoryManagementImpl implements CategoryManagement {

	private CategoryManagementAdapter adapter;
	
	@Override
	public ResponseBase addNewCategory(AddCategoryRequest request) {
		return adapter.addNewCategory(request);
	}

	@Override
	public FindCategoryResponse findAllCategories(boolean active) {
		return adapter.findAllCategories(active);
	}
	
	public void setAdapter(CategoryManagementAdapter adapter) {
		this.adapter = adapter;
	}

}
