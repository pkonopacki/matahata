package com.zwort.matahata.core.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends AbstractDictionaryEntity implements Serializable {

	private static final long serialVersionUID = 8141846210888966697L;
	
	@Column(name = "bank_id", nullable = false)
	private long bankId;
	
	@Column(name = "account_name")
	private String accountName;
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@Column(name = "balance")
	private Double balance;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "currency_id")
	private Currency currency;
	

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

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

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public String toString() {
		return String.valueOf(bankId) + accountName + accountNumber + String.valueOf(balance);
	}
	
}
