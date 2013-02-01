package com.zwort.matahata.core.sp.binder;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.PlanItem;
import com.zwort.matahata.core.sp.dto.PlanDTO;
import com.zwort.matahata.core.sp.dto.PlanItemDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PlanManagementBinder extends CommonBinder {
	
	private static final Log logger = LogFactory.getLog(PlanManagementBinder.class);	
	
	
	public Plan bindPlanWithPlanDto(PlanDTO dto) throws ServiceException, ServiceProviderException {
		Plan plan = new Plan();
		
		if (dto.getMonth() == null) {
			logger.error("Month cannot be null");
			throw new ServiceProviderException("Month cannot be null");
		
		} else {
			plan.setStartDate(getFirstDayOfMonth(dto.getMonth()));
			plan.setEndDate(getLastDayOfMonth(dto.getMonth()));
		}
		
		Set<PlanItem> planItemList = binsPlanItemsListWithPlanItemsDtoList(dto.getPlanItemDtoList());
		plan.getPlanItemsList().addAll(planItemList);
		
		return plan;
	}


	private Set<PlanItem> binsPlanItemsListWithPlanItemsDtoList(
			Set<PlanItemDTO> planItemDtoList)  throws ServiceException, ServiceProviderException {
		Set<PlanItem> planItemsList = new HashSet<PlanItem>();
		
		for (PlanItemDTO dto : planItemDtoList) {
			PlanItem planItem = bindPlanItemWithDto(dto);
			planItemsList.add(planItem);
		}
		
		return planItemsList;
	}


	private PlanItem bindPlanItemWithDto(PlanItemDTO dto) throws ServiceException, ServiceProviderException {
		PlanItem planItem = new PlanItem();
		Category category = null;
		
		if (dto.getCategoryAbbr() != null && !dto.getCategoryAbbr().equals("")) {
			category = facade.getCategoryByAbbr(dto.getCategoryAbbr());
		}
		
		if (category == null) {
			logger.error("Category [" + dto.getCategoryAbbr() + "] is not in database");
			throw new ServiceProviderException("Category [" + dto.getCategoryAbbr() + "] is not in database");
		}
		
		planItem.setAmount(getAmount(dto.getCatLimit()));
		planItem.setCategory(category);
		
		return planItem;
	}
	
}
