package com.zwort.matahata.core.service.impl;

import java.util.List;

import com.zwort.matahata.core.dao.DictionaryDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.service.DictionaryService;

public class DictionaryServiceImpl<E> extends AbstractBaseService<E> implements DictionaryService<E> {

	@Override
	public DictionaryDAO<E> getDao() {
		return (DictionaryDAO<E>) dao;
	}

	public void setDao(DictionaryDAO<E> dao) {
		super.setDao(dao);
	}


	@Override
	public List<E> findActive() throws ServiceException {

		try {
			return getDao().findActive();
		
		} catch (Throwable t) {
			throw new ServiceException("AbstractBaseService<E>.findActive failed: ", t);
		}
	
	}

}
