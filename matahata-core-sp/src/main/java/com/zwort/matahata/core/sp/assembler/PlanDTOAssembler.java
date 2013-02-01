package com.zwort.matahata.core.sp.assembler;

import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.PlanItem;
import com.zwort.matahata.core.sp.dto.PlanDTO;
import com.zwort.matahata.core.sp.dto.PlanItemDTO;

import java.util.HashSet;
import java.util.Set;

public class PlanDTOAssembler {
	
	public PlanDTO assemblePlanDto(Plan plan) {
		PlanDTO dto = new PlanDTO();
		
		//TODO: Implement this assembler (po chuj?)
		Set<PlanItemDTO> planItemDtoList = assemblePlanItemDtoList(plan.getPlanItemsList());
		dto.getPlanItemDtoList().addAll(planItemDtoList);
		dto.setStartDate(plan.getStartDate());
		dto.setEndDate(plan.getStartDate());
		dto.setId(plan.getId());
		
		return dto;
	}

	private Set<PlanItemDTO> assemblePlanItemDtoList(Set<PlanItem> planItemsList) {
		Set<PlanItemDTO> planItemDtoList = new HashSet<PlanItemDTO>();
		
		for (PlanItem planItem : planItemsList) {
			PlanItemDTO dto = assemblePlanItemDto(planItem);
			planItemDtoList.add(dto);
		}
		
		return planItemDtoList;
	}

	private PlanItemDTO assemblePlanItemDto(PlanItem planItem) {
		PlanItemDTO dto = new PlanItemDTO();
		dto.setCategoryAbbr(planItem.getCategory().getAbbreviation());
		dto.setCatLimit(planItem.getAmount());
		
		return dto;
	}

}
