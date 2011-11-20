package com.zwort.matahata.core.sp.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddAccountRequest", propOrder = {
    "accountName",
    "accountNumber",
    "bankId",
    "currencyISOCode",
    "description",
    "active"
})
public class AddAccountRequest {
	
	@XmlElement(name = "AccountName", namespace = "http://www.zwort.com/matahata/")
	protected String accountName;

	@XmlElement(name = "AccountNumber", namespace = "http://www.zwort.com/matahata/")
	protected String accountNumber;
	
	@XmlElement(name = "BankId", namespace = "http://www.zwort.com/matahata/")
	protected Long bankId;

	@XmlElement(name = "CurrencyISOCode", namespace = "http://www.zwort.com/matahata/")
	protected String currencyISOCode;

	@XmlElement(name = "Description", namespace = "http://www.zwort.com/matahata/")
	protected String description;

	@XmlElement(name = "Active", namespace = "http://www.zwort.com/matahata/")
	protected boolean active;

	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}

	public String getCurrencyISOCode() {
		return currencyISOCode;
	}

	public void setCurrencyISOCode(String currencyISOCode) {
		this.currencyISOCode = currencyISOCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
