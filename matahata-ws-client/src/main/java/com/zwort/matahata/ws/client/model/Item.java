package com.zwort.matahata.ws.client.model;

import java.util.Date;

public class Item {
	
	private ItemType type;
	
	private Date date;
	
	private String source;

	private String location;
	
	private String categoryAbbr;
	
	private String srcAccountNo;
	
	private String destAccountNo;

	private Double amount;
	
	private String description;
	
	private String benefInitials;
	
	private String payerInitials;
	
	private Boolean refundable;
	
	private Boolean cleared;
	
	private Boolean debt;
	
	private Double originalAmount;
	
	private String originalCurrency;

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

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

	public String getCategoryAbbr() {
		return categoryAbbr;
	}

	public void setCategoryAbbr(String categoryAbbr) {
		this.categoryAbbr = categoryAbbr;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBenefInitials() {
		return benefInitials;
	}

	public void setBenefInitials(String benefInitials) {
		this.benefInitials = benefInitials;
	}

	public String getPayerInitials() {
		return payerInitials;
	}

	public void setPayerInitials(String payerInitials) {
		this.payerInitials = payerInitials;
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

	public Boolean getDebt() {
		return debt;
	}

	public void setDebt(Boolean debt) {
		this.debt = debt;
	}

	public Double getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(Double originalAmount) {
		this.originalAmount = originalAmount;
	}

	public String getOriginalCurrency() {
		return originalCurrency;
	}

	public void setOriginalCurrency(String originalCurrency) {
		this.originalCurrency = originalCurrency;
	}
	
}
