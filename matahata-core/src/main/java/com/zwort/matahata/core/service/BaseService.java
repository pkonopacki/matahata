package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;

import java.util.List;

public interface BaseService<E> {
	
	List<E> findAll() throws ServiceException;
	
	E findById(long id) throws ServiceException;
	
	E add(E entity) throws ServiceException;
	
	void update(E entity) throws ServiceException;

	void delete(E entity) throws ServiceException;
	

}
