package com.zwort.matahata.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.zwort.matahata.core.dao.BaseDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.service.BaseService;

public abstract class AbstractBaseService<E> implements BaseService<E> {

	protected BaseDAO<E> dao;
	
	private final Log logger = LogFactory.getLog(AbstractBaseService.class);
	

	public void setDao(BaseDAO<E> dao) {
		this.dao = dao;
	}
	
	public BaseDAO<E> getDao() {
		return dao;
	}

	@Override
	@Transactional
	public E add(E entity) throws ServiceException {
		logger.info("Entity: " + entity.toString());
		
		try {
			return dao.merge(entity);
		
		} catch (Throwable t) {
			throw new ServiceException("AbstractBaseService<E>.add failed: " + t.getLocalizedMessage());
		}

	}

	@Override
	public void delete(E entity) throws ServiceException {

		try {
			dao.remove(entity);
		
		} catch (Throwable t) {
			throw new ServiceException("AbstractBaseService<E>.delete failed: ", t);
		}

	}

	@Override
	public List<E> findAll() throws ServiceException {

		try {
			return dao.findAll();
		
		} catch (Throwable t) {
			throw new ServiceException("AbstractBaseService<E>.findAll failed: ", t);
		}

	}

	@Override
	public E findById(long id) throws ServiceException {

		try {
			return dao.findById(id);
		
		} catch (Throwable t) {
			throw new ServiceException("AbstractBaseService<E>.findAll failed: ", t);
		}

	}

	@Override
	public void update(E entity) throws ServiceException {

		try {
			dao.merge(entity);
		
		} catch (Throwable t) {
			throw new ServiceException("AbstractBaseService<E>.update failed: ", t);
		}

	}

}
