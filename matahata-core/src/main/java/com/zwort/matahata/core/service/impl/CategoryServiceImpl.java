package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.CategoryDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.service.CategoryService;

import javax.persistence.NoResultException;

public class CategoryServiceImpl extends DictionaryServiceImpl<Category>
		implements CategoryService {

	public CategoryDAO getDao() {
		return (CategoryDAO) dao;
	}

	public void setDao(CategoryDAO dao) {
		super.setDao(dao);
	}

	@Override
	public Category getByAbbreviation(String abbr) throws ServiceException {
		
		try {
			return getDao().getByAbbreviation(abbr);

        } catch (NoResultException nre) {
            throw new ServiceException("CategoryServiceImpl#findByAbbreviation failed. No category with abbreviation [" + abbr + "] found.");

        } catch (Throwable t){
			throw new ServiceException("CategoryServiceImpl#findByAbbreviation failed: " + t.getMessage(), t);
		}
	}

}
