package com.zwort.matahata.core.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OBJECT_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("OPERATION")
public class Operation extends AbstractBaseEntitiy {

	private static final long serialVersionUID = -6778626087116213988L;
	
	@Column(name = "operation_date")
	private Date date;

	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "account_id")
	private Account account;

	@Column(name = "amount")
	private double amount;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "currency_id")
	private Currency currency;

	@Column(name = "orig_amount")
	private double originalAmount;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "orig_currency_id")
	private Currency originalCurrency;

	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "item_id")
	private Item item;


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public double getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(double originalAmount) {
		this.originalAmount = originalAmount;
	}

	public Currency getOriginalCurrency() {
		return originalCurrency;
	}

	public void setOriginalCurrency(Currency originalCurrency) {
		this.originalCurrency = originalCurrency;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
