package com.zwort.matahata.core.sp.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddPlanResponse", propOrder = {
	    "id"
})
public class AddPlanResponse extends ResponseBase {
	
	//TODO:Could go to more abstract add entity base
	@XmlElement(name = "PlanId", namespace = "http://www.zwort.com/matahata/")
	protected Long planId;

	
	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}
	
}
