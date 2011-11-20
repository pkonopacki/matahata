package com.zwort.matahata.core.sp.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddPlanRequest", propOrder = {
    "date",
    "categoryAbbr",
    "amount"
})
public class ExpenseWS {
	
	@XmlElement(name = "Date", namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private Date date;
	
	@XmlElement(name = "CategoryAbbr", namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String categoryAbbr;
	
	@XmlElement(name = "Amount", namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private double amount;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategoryAbbr() {
		return categoryAbbr;
	}

	public void setCategoryAbbr(String categoryAbbr) {
		this.categoryAbbr = categoryAbbr;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
