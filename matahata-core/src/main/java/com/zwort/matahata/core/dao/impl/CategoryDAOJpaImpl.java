package com.zwort.matahata.core.dao.impl;

import javax.persistence.Query;

import com.zwort.matahata.core.dao.CategoryDAO;
import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Category;

public class CategoryDAOJpaImpl extends DictionaryDAOJpaImpl<Category>
		implements CategoryDAO {
	
	public CategoryDAOJpaImpl() {
		this(Category.class);
	}

	public CategoryDAOJpaImpl(Class<Category> type) {
		super(type);
	}

	@Override
	public Category getByAbbreviation(String abbr) throws DAOException {
		Query q = entityManager.createQuery("FROM Category c WHERE c.abbreviation = :abbr");
		q.setParameter("abbr", abbr);
		return (Category) q.getSingleResult();
	}

}
