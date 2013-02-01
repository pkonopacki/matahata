package com.zwort.matahata.core.sp.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddExpenseRequest", propOrder = {
    "date",
    "location",
    "categoryAbbr",
    "srcAccountNo",
    "description",
    "amount",
    "currencyISO",
    "originalAmount",
    "originalCurrencyISO",
    "payerInitials",
    "beneficiaryInitials",
    "refundable",
    "cleared"
})
public class AddExpenseRequest {

	@XmlElement(name = "Date")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private Date date;

	@XmlElement(name = "Location")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String location;

	@XmlElement(name = "CategoryAbbr")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String categoryAbbr;

	@XmlElement(name = "SrcAccountNo")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String srcAccountNo;

	@XmlElement(name = "description")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String description;

	@XmlElement(name = "Amount")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private Double amount;

	@XmlElement(name = "CurrencyISO")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String currencyISO;
	
	@XmlElement(name = "OriginalAmount")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private Double originalAmount;

	@XmlElement(name = "OriginalCurrencyISO")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String originalCurrencyISO;

	@XmlElement(name = "PayerInitials")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String payerInitials;
	
	@XmlElement(name = "BeneficiaryInitials")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private String beneficiaryInitials;

	@XmlElement(name = "Refundable")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private Boolean refundable;

	@XmlElement(name = "Cleared")//, namespace = "http://com.zwort/matahata/ExpenseManagement/1")
	private Boolean cleared;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategoryAbbr() {
		return categoryAbbr;
	}

	public void setCategoryAbbr(String categoryAbbr) {
		this.categoryAbbr = categoryAbbr;
	}

	public String getSrcAccountNo() {
		return srcAccountNo;
	}

	public void setSrcAccountNo(String srcAccountNo) {
		this.srcAccountNo = srcAccountNo;
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

	public String getPayerInitials() {
		return payerInitials;
	}

	public void setPayerInitials(String payerInitials) {
		this.payerInitials = payerInitials;
	}

	public String getBeneficiaryInitials() {
		return beneficiaryInitials;
	}

	public void setBeneficiaryInitials(String beneficiaryInitials) {
		this.beneficiaryInitials = beneficiaryInitials;
	}

	public Boolean getRefundable() {
		return refundable;
	}

	public void setRefundable(Boolean refundable) {
		this.refundable = refundable;
	}

	public Boolean getCleared() {
		return cleared;
	}

	public void setCleared(Boolean cleared) {
		this.cleared = cleared;
	}
	
}
