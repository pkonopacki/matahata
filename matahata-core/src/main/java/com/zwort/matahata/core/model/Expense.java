package com.zwort.matahata.core.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("EXPENSE")
public class Expense extends Item {

	private static final long serialVersionUID = 4304855162661288943L;
	
	@Column(name = "is_refundable")
	private boolean refundable;

	@Column(name = "is_cleared")
	private boolean cleared;

	@Column(name = "location")
	private String location;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "plan_id")
	private Plan plan;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "src_account_id")
	private Account srcAccount;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "category_id")
	private Category category;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "beneficiary_id")
	private Beneficiary beneficiary;

	
	public boolean isRefundable() {
		return refundable;
	}

	public void setRefundable(boolean refundable) {
		this.refundable = refundable;
	}

	public boolean isCleared() {
		return cleared;
	}

	public void setCleared(boolean cleared) {
		this.cleared = cleared;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Account getSrcAccount() {
		return srcAccount;
	}

	public void setSrcAccount(Account srcAccount) {
		this.srcAccount = srcAccount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}
	
}
