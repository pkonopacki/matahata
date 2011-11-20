package com.zwort.matahata.core.sp.service;

import java.util.List;

import com.zwort.matahata.core.sp.dto.CategoryDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public interface CategoryManagementService {
	
	public Long addNewCategory(CategoryDTO dto) throws ServiceProviderException;
	
	public List<CategoryDTO> findAllCategories(boolean active) throws ServiceProviderException;

}
