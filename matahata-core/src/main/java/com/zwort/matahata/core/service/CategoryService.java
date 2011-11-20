package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Category;

public interface CategoryService extends DictionaryService<Category> {
	
	public Category getByAbbreviation(String abbr) throws ServiceException;
	
}
