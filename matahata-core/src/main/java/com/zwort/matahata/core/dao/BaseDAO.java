package com.zwort.matahata.core.dao;

import java.util.List;

public interface BaseDAO<E> {

	E merge(E entity);

	void remove(E entity);
	
	List<E> findAll();
	
	E findById(long id);
	
}
