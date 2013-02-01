package com.zwort.matahata.core.sp.service.impl;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.sp.assembler.CategoryDTOAssembler;
import com.zwort.matahata.core.sp.binder.CategoryManagementBinder;
import com.zwort.matahata.core.sp.dto.CategoryDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.CategoryManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

public class CategoryManagementServiceImpl extends AbstractManagementService implements CategoryManagementService {

	// TODO: Often used methods and logger to BaseService

	private static final Log logger = LogFactory
			.getLog(CategoryManagementServiceImpl.class);

	private CategoryManagementBinder binder;

	@Override
	public Long addNewCategory(CategoryDTO dto) throws ServiceProviderException {

		try {
			return facade.saveCategory(binder.bindCategory(dto)).getId();

		} catch (ServiceException se) {
			logger.error(
					"CategoryManagementServiceImpl.addNewCategory failed: ", se);
			throw new ServiceProviderException(
					"CategoryManagementServiceImpl.addNewCategory failed: ", se);
		}

	}

	@Override
	public List<CategoryDTO> findAllCategories(boolean active)
			throws ServiceProviderException {
		
		try {
			List<Category> categories = facade.findAllCategories(active);
			return new CategoryDTOAssembler().categoriesToDtos(categories);

		} catch (ServiceException se) {
			logger.error(
					"CategoryManagementServiceImpl.findAllCategories failed: ", se);
			throw new ServiceProviderException(
					"CategoryManagementServiceImpl.findAllCategories failed: ", se);
		}
	
	}
	
	//Spring setters

	public void setBinder(CategoryManagementBinder binder) {
		this.binder = binder;
	}
	
}
