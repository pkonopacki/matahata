package com.zwort.matahata.core.service.impl;

import java.util.Date;
import java.util.List;

import com.zwort.matahata.core.dao.EntityDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.service.EntityService;

public class EntityServiceImpl<E> extends AbstractBaseService<E> implements EntityService<E> {


	public void setDao(EntityDAO<E> dao) {
		super.setDao(dao);
	}
	
	@Override
	public EntityDAO<E> getDao() {
		return (EntityDAO<E>) dao;
	}

	@Override
	public List<E> findByDates(Date dateFrom, Date dateTo)
			throws ServiceException {
		
		try {
			return getDao().findByDates(dateFrom, dateTo);
		
		} catch (Throwable t) {
			throw new ServiceException("EntityServiceImpl<E>.findByDates failed ", t);
		}
	
	}
	
}
