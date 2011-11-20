package com.zwort.matahata.core.sp.dto;

import java.util.HashSet;
import java.util.Set;

import com.zwort.matahata.core.model.Month;

public class PlanDTO extends BaseDTO {
	
	private Month month;
	
	private Set<PlanItemDTO> planItemDtoList;
	
	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Set<PlanItemDTO> getPlanItemDtoList() {
		
		if (planItemDtoList == null) {
			planItemDtoList = new HashSet<PlanItemDTO>();
		}
		
		return planItemDtoList;
	}

}
