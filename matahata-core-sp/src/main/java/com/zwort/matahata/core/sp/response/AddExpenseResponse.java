package com.zwort.matahata.core.sp.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddExpenseResponse", propOrder = {
	    "id"
})

public class AddExpenseResponse extends ResponseBase {

	//TODO:Could go to more abstract add entity base
	@XmlElement(name = "Id")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	protected Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
