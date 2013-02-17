package com.zwort.matahata.core.dao.impl;


import com.zwort.matahata.core.dao.DictionaryDAO;

import javax.persistence.Query;
import java.util.List;

public class DictionaryDAOJpaImpl<E> extends AbstractJpaDAO<E> implements DictionaryDAO<E> {

	public DictionaryDAOJpaImpl() {
		super();
	}
	
	public DictionaryDAOJpaImpl(Class<E> type) {
		super(type);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<E> findActive() {
		Query q = entityManager.createQuery("SELECT e FROM " + entityClass.getName() + " e WHERE e.active = 1");
		return q.getResultList();
	}

}