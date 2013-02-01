package com.zwort.matahata.core.sp.ws;

import com.zwort.matahata.core.sp.request.AddCategoryRequest;
import com.zwort.matahata.core.sp.response.FindCategoryResponse;
import com.zwort.matahata.core.sp.response.ResponseBase;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(targetNamespace = "http://matahata.zwort.com/core/sp/ws/CategoryManagement", name = "CategoryManagement")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)

public interface CategoryManagement {
	
	public ResponseBase addNewCategory(@WebParam AddCategoryRequest request);
	
	FindCategoryResponse findAllCategories(boolean active);

}
