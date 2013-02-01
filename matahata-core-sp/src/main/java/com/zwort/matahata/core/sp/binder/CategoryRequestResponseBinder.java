package com.zwort.matahata.core.sp.binder;

import com.zwort.matahata.core.sp.dto.CategoryDTO;
import com.zwort.matahata.core.sp.request.AddCategoryRequest;
import com.zwort.matahata.core.sp.response.AddAccountResponse;
import com.zwort.matahata.core.sp.response.FindCategoryResponse;

import java.util.Date;
import java.util.List;

public class CategoryRequestResponseBinder {

	public CategoryDTO bindCategoryDTOwithAddCategoryRequest(AddCategoryRequest request) {
		CategoryDTO dto = new CategoryDTO();
		
		dto.setAbbreviation(request.getAbbreviation());
		dto.setActive(new Boolean(request.isActive()));
		dto.setCreationDate(new Date());
		dto.setLastUpdate(new Date());
		dto.setDescription(request.getDescription());
		
		return dto;
		
	}
	
	public AddAccountResponse bindResponse(Long id) {
		AddAccountResponse resp = new AddAccountResponse();
		resp.setAccountId(id);
		return resp;
	}
	
	public FindCategoryResponse bindFindAllCategoryResponse(List<CategoryDTO> dtoSet) {
		FindCategoryResponse response = new FindCategoryResponse();
		response.getCategories().addAll(dtoSet);
		return response;
	}

}
