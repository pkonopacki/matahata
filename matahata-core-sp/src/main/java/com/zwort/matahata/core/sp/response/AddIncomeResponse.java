package com.zwort.matahata.core.sp.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddIncomeResponse", propOrder = {
	    "id"
})
public class AddIncomeResponse extends ResponseBase {
	
	//TODO:Could go to more abstract add entity base
	@XmlElement(name = "IncomeId", namespace = "http://www.zwort.com/matahata/")
	protected Long incomeId;

	public Long getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}

}
