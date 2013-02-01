package com.zwort.matahata.core.dao.impl;

import java.util.Date;

import javax.persistence.Query;

import com.zwort.matahata.core.dao.PlanDAO;
import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.PlanItem;
import org.springframework.stereotype.Repository;

@Repository(value = "planDAO")
public class PlanDAOJpaImpl extends EntityDAOJpaImpl<Plan> implements PlanDAO {

	public PlanDAOJpaImpl() {
		super(Plan.class);
	}

	public PlanDAOJpaImpl(Class<Plan> type) {
		super(type);
	}
	
	@Override
	public Plan getCurrentAccountPlan(Date date) throws DAOException {
		Query q = entityManager.createQuery("Select p FROM Plan p WHERE p.startDate <= :date AND p.endDate >= :date");
		q.setParameter("date", date);
		return (Plan) q.getSingleResult();
	}
	
	public boolean isPlanExist(Date startDate, Date endDate) throws DAOException {
		boolean result = false;
		
		Query q = entityManager.createQuery("FROM Plan p WHERE p.startDate BETWEEN :startDate AND :endDate OR p.endDate BETWEEN :startDate AND :endDate");
		q.setParameter("startDate", startDate);
		q.setParameter("endDate", endDate);
		
		if (q.getResultList().size() > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public PlanItem savePlanItem(PlanItem planItem) {
		return entityManager.merge(planItem);
	}

}
