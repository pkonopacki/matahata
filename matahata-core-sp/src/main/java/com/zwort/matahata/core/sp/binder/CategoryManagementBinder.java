package com.zwort.matahata.core.sp.binder;

import java.util.Date;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.sp.dto.CategoryDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public class CategoryManagementBinder extends CommonBinder {
	
	public Category bindCategory(CategoryDTO dto) throws ServiceException, ServiceProviderException {
		Category category = new Category();

		isCategoryAbbreviationUnique(dto.getAbbreviation());
		category.setAbbreviation(dto.getAbbreviation());

		Date creationDate = new Date();

		if (dto.getCreationDate() != null) {
			creationDate = dto.getCreationDate();
		}
		category.setCreationDate(creationDate);

		Date lastUpdate = new Date();

		if (dto.getLastUpdate() != null) {
			lastUpdate = dto.getLastUpdate();
		}
		category.setLastUpdate(lastUpdate);

		// TODO: Default properties to properties

		boolean active = false;

		if (dto.isActive() != null) {
			active = dto.isActive();
		}
		category.setActive(active);

		if (dto.getDescription() == null || dto.getDescription().equals("")) {
			throw new ServiceProviderException(
					"Description canot be null nor empty string");
		}
		category.setDescription(dto.getDescription());
		
		return category;
	}
	
}
