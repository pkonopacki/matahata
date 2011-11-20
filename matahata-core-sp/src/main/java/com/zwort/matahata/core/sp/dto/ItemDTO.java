package com.zwort.matahata.core.sp.dto;

import java.util.Date;

public class ItemDTO extends BaseDTO {

	private String description;
	
	private Date date;

	private Double amount;
	
	private String currencyIso;

	private Double originalAmount;

	private String originalCurrencyISO;

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getCurrencyIso() {
		return currencyIso;
	}

	public void setCurrencyIso(String currencyIso) {
		this.currencyIso = currencyIso;
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
