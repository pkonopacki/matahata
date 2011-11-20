package com.zwort.matahata.core.sp.binder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import zwort.com.matahata.services._1.AddPlanRequest;
import zwort.com.matahata.services._1.AddPlanResponse;
import zwort.com.matahata.services._1.PlanItemWS;

import com.zwort.matahata.core.sp.dto.PlanDTO;
import com.zwort.matahata.core.sp.dto.PlanItemDTO;

public class PlanRequestResponseBinder extends BaseRequestResponseBinder {
	
	public PlanDTO bindPlanDtoFromAddPlanRequest(AddPlanRequest request) {
		PlanDTO dto = new PlanDTO();
		
		Set<PlanItemDTO> planItemsDtoList = bindPlanItemsDtoList(request.getPlanItemsWSList().getPlanItemWS());
		dto.setMonth(bindMonthFromWSMonth(request.getMonth()));
		dto.getPlanItemDtoList().addAll(planItemsDtoList);

		return dto;
	}
	
	private Set<PlanItemDTO> bindPlanItemsDtoList(List<PlanItemWS> planItemsList) {
		Set<PlanItemDTO> planItemsDtoList = new HashSet<PlanItemDTO>();
		
		for (PlanItemWS planItemWs : planItemsList) {
			PlanItemDTO dto = bindItemDtoWithPlanItemWs(planItemWs);
			planItemsDtoList.add(dto);
		}
		
		return planItemsDtoList;
	}

	private PlanItemDTO bindItemDtoWithPlanItemWs(PlanItemWS planItemWs) {
		PlanItemDTO dto = new PlanItemDTO();
		
		dto.setCategoryAbbr(planItemWs.getCategoryAbbr());
		dto.setCatLimit(planItemWs.getCatLimit());
		
		return dto;
	}

	public AddPlanResponse bindAddPlanResponseFromLong(Long id) {
		AddPlanResponse response = new AddPlanResponse();
		
		response.setId(id);
		
		return response;
	}

}
