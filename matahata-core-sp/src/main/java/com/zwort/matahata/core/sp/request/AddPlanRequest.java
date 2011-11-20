package com.zwort.matahata.core.sp.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddPlanRequest", propOrder = {
    "startDate",
    "endDate",
    "accNum",
    "amount"
})
public class AddPlanRequest {

	@XmlElement(name = "StartDate", namespace = "http://www.zwort.com/matahata/")
	private Date startDate;

	@XmlElement(name = "EndDate", namespace = "http://www.zwort.com/matahata/")
	private Date endDate;
	
	@XmlElement(name = "AccNum", namespace = "http://www.zwort.com/matahata/")
	private String accNum;
	
	@XmlElement(name = "Amount", namespace = "http://www.zwort.com/matahata/")
	private double amount;

	
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

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
