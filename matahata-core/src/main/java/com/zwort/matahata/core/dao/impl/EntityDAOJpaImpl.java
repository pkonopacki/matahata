package com.zwort.matahata.core.dao.impl;

import com.zwort.matahata.core.dao.EntityDAO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class EntityDAOJpaImpl<E> extends AbstractJpaDAO<E> implements EntityDAO<E> {
	
	private static final Log logger = LogFactory.getLog(EntityDAOJpaImpl.class);

	public EntityDAOJpaImpl() {
		super();
	}

	public EntityDAOJpaImpl(Class<E> type) {
		super(type);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<E> findByDates(Date dateFrom, Date dateTo) {
		Query q = entityManager.createQuery("FROM " + entityClass.getName() + " e WHERE e.date >= :dateFrom AND e.date <= :dateTo");

		logger.debug("DAO date from: " + dateFrom);
		logger.debug("DAO date to: " + dateTo);
		
		q.setParameter("dateFrom", dateFrom);
		q.setParameter("dateTo", dateTo);
		return q.getResultList();
	}

}
