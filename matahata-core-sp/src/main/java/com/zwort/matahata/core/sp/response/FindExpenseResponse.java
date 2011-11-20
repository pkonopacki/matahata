package com.zwort.matahata.core.sp.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.zwort.matahata.core.sp.request.ExpenseWS;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindExpenseResponse", propOrder = {
	    "expensesList"
})
public class FindExpenseResponse extends ResponseBase {
	
	@XmlElement(name = "ExpensesList")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	List<ExpenseWS> expensesList;

	public List<ExpenseWS> getExpensesList() {
		return expensesList;
	}

	public void setExpensesList(List<ExpenseWS> expensesList) {
		this.expensesList = expensesList;
	}
	
}
