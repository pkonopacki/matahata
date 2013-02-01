package com.zwort.matahata.core.sp.dto;

import com.zwort.matahata.core.model.Month;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PlanDTO extends BaseDTO {
	
	private Month month;
	
	private Date startDate;
	
	private Date endDate;
	
	private Set<PlanItemDTO> planItemDtoList;
	
	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<PlanItemDTO> getPlanItemDtoList() {
		
		if (planItemDtoList == null) {
			planItemDtoList = new HashSet<PlanItemDTO>();
		}
		
		return planItemDtoList;
	}

}