package com.zwort.matahata.core.sp.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddTransferRequest", propOrder = {
    "srcAccountNo",
    "destAccountNo",
    "date",
    "description",
    "amount",
    "originalAmount",
    "originalCurrencyISO"
})
public class AddTransferRequest {
	
	@XmlElement(name = "SrcAccountNo", namespace = "http://www.zwort.com/matahata/")
	private String srcAccountNo;
	
	@XmlElement(name = "DestAccountNo", namespace = "http://www.zwort.com/matahata/")
	private String destAccountNo;
	
	@XmlElement(name = "Date", namespace = "http://www.zwort.com/matahata/")
	private Date date;
	
	@XmlElement(name = "Description", namespace = "http://www.zwort.com/matahata/")
	private String description;
	
	@XmlElement(name = "Amount", namespace = "http://www.zwort.com/matahata/")
	private Double amount;

	@XmlElement(name = "OriginalAmount", namespace = "http://www.zwort.com/matahata/")
	private Double originalAmount;

	@XmlElement(name = "OriginalCurrencyISO", namespace = "http://www.zwort.com/matahata/")
	private String originalCurrencyISO;

	public String getSrcAccountNo() {
		return srcAccountNo;
	}

	public void setSrcAccountNo(String srcAccountNo) {
		this.srcAccountNo = srcAccountNo;
	}

	public String getDestAccountNo() {
		return destAccountNo;
	}

	public void setDestAccountNo(String destAccountNo) {
		this.destAccountNo = destAccountNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(Double originalAmount) {
		this.originalAmount = originalAmount;
	}

	public String getOriginalCurrencyISO() {
		return originalCurrencyISO;
	}

	public void setOriginalCurrencyISO(String originalCurrencyISO) {
		this.originalCurrencyISO = originalCurrencyISO;
	}
	
}
