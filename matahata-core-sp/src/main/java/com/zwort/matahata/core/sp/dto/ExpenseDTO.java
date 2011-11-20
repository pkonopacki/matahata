package com.zwort.matahata.core.sp.dto;


public class ExpenseDTO extends ItemDTO {
	
	private boolean refundable;

	private boolean cleared;

	private String location;
	
	private String srcAccountNo;
	
	private String categoryAbbr;
	
	private String categoryDesc;
	
	private String payerInitials;
	
	private String beneficiaryInitials;

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

	public String getSrcAccountNo() {
		return srcAccountNo;
	}

	public void setSrcAccountNo(String srcAccountNo) {
		this.srcAccountNo = srcAccountNo;
	}

	public String getCategoryAbbr() {
		return categoryAbbr;
	}

	public void setCategoryAbbr(String categoryAbbr) {
		this.categoryAbbr = categoryAbbr;
	}
	
	public String getCategoryDesc() {
		return categoryDesc;
	}

	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
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

}