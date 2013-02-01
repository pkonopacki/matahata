package com.zwort.matahata.core.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zwort.matahata.core.dao.PlanDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.PlanItem;
import com.zwort.matahata.core.service.PlanService;

import javax.persistence.NoResultException;

@Service
public class PlanServiceImpl extends EntityServiceImpl<Plan> implements
		PlanService {
	
	@Override
	public PlanDAO getDao() {
		return (PlanDAO) dao;
	}
	
	@Autowired
    public void setDao(PlanDAO dao) {
		super.setDao(dao);
	}
	
	@Override
	public Plan getPlanByDate(Date date)
			throws ServiceException {
		
		try {
			return getDao().getCurrentAccountPlan(date);

        } catch (NoResultException nre) {
            throw new ServiceException("PlanServiceImpl#getPlanByDate failed. No plan for date [" + date.toString() + "] found.");

        } catch (Throwable t) {
			throw new ServiceException("PlanServiceImpl#getPlanByDate failed:" + t.getMessage(), t);
		}
	}
	
	@Override
	@Transactional
	public Plan add(Plan entity) throws ServiceException {
		Set<PlanItem> planItemSavedList = new HashSet<PlanItem>();
		
		try {
		
			if (getDao().isPlanExist(entity.getStartDate(), entity.getEndDate())) {
				throw new ServiceException("Cannot add plan. Plan between set dates exists already.");
			}
			
			for (PlanItem planItem : entity.getPlanItemsList()) {
				PlanItem planItemSaved = getDao().savePlanItem(planItem);
				planItemSavedList.add(planItemSaved);
			}
			
			entity.getPlanItemsList().clear();
			entity.getPlanItemsList().addAll(planItemSavedList);
			
			return super.add(entity);

		} catch (Throwable t) {
			throw new ServiceException("PlanServiceImpl#PlanServiceImpl failed:" + t.getMessage(), t);
		}
	}

}
