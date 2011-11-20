package com.zwort.matahata.core.sp.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddExpenseRequest", propOrder = {
    "date",
    "source",
    "destAccountNo",
    "description",
    "amount",
    "currencyISO",
    "originalAmount",
    "originalCurrencyISO",
    "beneficiaryInitials",
    "debt"
})
public class AddIncomeRequest {
	
	@XmlElement(name = "Date", namespace = "http://www.zwort.com/matahata/")
	private Date date;

	@XmlElement(name = "Source", namespace = "http://www.zwort.com/matahata/")
	private String source;

	@XmlElement(name = "DestAccountNo", namespace = "http://www.zwort.com/matahata/")
	private String destAccountNo;

	@XmlElement(name = "description", namespace = "http://www.zwort.com/matahata/")
	private String description;

	@XmlElement(name = "Amount", namespace = "http://www.zwort.com/matahata/")
	private Double amount;

	@XmlElement(name = "CurrencyISO", namespace = "http://www.zwort.com/matahata/")
	private String currencyISO;
	
	@XmlElement(name = "OriginalAmount", namespace = "http://www.zwort.com/matahata/")
	private Double originalAmount;

	@XmlElement(name = "OriginalCurrencyISO", namespace = "http://www.zwort.com/matahata/")
	private String originalCurrencyISO;
	
	@XmlElement(name = "BeneficiaryInitials", namespace = "http://www.zwort.com/matahata/")
	private String beneficiaryInitials;

	@XmlElement(name = "Debt", namespace = "http://www.zwort.com/matahata/")
	private Boolean debt;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestAccountNo() {
		return destAccountNo;
	}

	public void setDestAccountNo(String destAccountNo) {
		this.destAccountNo = destAccountNo;
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

	public String getCurrencyISO() {
		return currencyISO;
	}

	public void setCurrencyISO(String currencyISO) {
		this.currencyISO = currencyISO;
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

	public String getBeneficiaryInitials() {
		return beneficiaryInitials;
	}

	public void setBeneficiaryInitials(String beneficiaryInitials) {
		this.beneficiaryInitials = beneficiaryInitials;
	}

	public Boolean getDebt() {
		return debt;
	}

	public void setDebt(Boolean debt) {
		this.debt = debt;
	}
	
}
