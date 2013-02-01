package com.zwort.matahata.core.sp.service;

import com.zwort.matahata.core.sp.dto.CategoryDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

import java.util.List;

public interface CategoryManagementService {
	
	public Long addNewCategory(CategoryDTO dto) throws ServiceProviderException;
	
	public List<CategoryDTO> findAllCategories(boolean active) throws ServiceProviderException;

}
