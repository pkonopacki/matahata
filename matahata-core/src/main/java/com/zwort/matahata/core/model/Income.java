package com.zwort.matahata.core.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@NamedQueries({
//	@NamedQuery(name = "findAllIncomes", query = "select i from Income i order by i.date")
//})

@Entity
@DiscriminatorValue("INCOME")
public class Income extends Item {

	private static final long serialVersionUID = 2303657671837249822L;

	@Column(name = "source")
	private String source;
	
	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "dest_account_id")
	private Account destAccount;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "category_id")
	private Category incomeCategory;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Account getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(Account destAccount) {
		this.destAccount = destAccount;
	}

	public Category getIncomeCategory() {
		return incomeCategory;
	}

	public void setIncomeCategory(Category incomeCategory) {
		this.incomeCategory = incomeCategory;
	}
	
}