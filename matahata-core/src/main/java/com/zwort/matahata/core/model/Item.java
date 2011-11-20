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
@Table(name = "item")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OBJECT_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ITEM")
public class Item extends AbstractBaseEntitiy {

	private static final long serialVersionUID = 3141118248742210853L;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "event_date")
	private Date date;

	@Column(name = "amount")
	private double amount;

	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "currency_id")
	private Currency currency;
	
	@Column(name = "orig_amount")
	private double originalAmount;

	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "orig_currency_id")
	private Currency originalCurrency;
	

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
	
}
