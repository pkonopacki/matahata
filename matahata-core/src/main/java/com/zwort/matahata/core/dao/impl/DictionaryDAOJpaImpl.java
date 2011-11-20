package com.zwort.matahata.core.dao.impl;


import java.util.List;

import javax.persistence.Query;

import com.zwort.matahata.core.dao.DictionaryDAO;

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