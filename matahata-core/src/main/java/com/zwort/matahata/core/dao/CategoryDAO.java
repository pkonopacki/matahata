package com.zwort.matahata.core.dao;

import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Category;

public interface CategoryDAO extends DictionaryDAO<Category> {
	
	public Category getByAbbreviation(String abbr) throws DAOException;

}
