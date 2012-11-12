package com.zwort.matahata.core.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.zwort.matahata.core.dao.BaseDAO;
import com.zwort.matahata.core.exception.DAOException;

public abstract class AbstractJpaDAO<E> implements BaseDAO<E> {

	protected Class<E> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;
	

	public AbstractJpaDAO() {
		super();
	}

	public AbstractJpaDAO(Class<E> type) {
		this.entityClass = type;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		Query q = entityManager.createQuery("FROM " + entityClass.getName());
		return (List<E>) q.getResultList();
	}

	@Override
	public E findById(long id) {
		return entityManager.find(entityClass, id);
	}

	@Override
	public E merge(E entity) {
		return entityManager.merge(entity);
	}

	@Override
	public void remove(E entity) {
		entityManager.remove(entity);

	}
	
	protected E getUniqueRecord(List<E> list) throws DAOException {
		
		if (list.isEmpty()) {
			return null;

		} else if (list.size() > 1) {
			throw new DAOException("More then one record found for entity: " + entityClass.getName());
			
		} else {
			return list.get(0);
		}
	}

}
