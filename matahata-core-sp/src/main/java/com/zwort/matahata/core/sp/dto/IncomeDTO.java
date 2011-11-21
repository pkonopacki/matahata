package com.zwort.matahata.core.sp.dto;

public class IncomeDTO extends ItemDTO {
	
	private String source;
	
	private String categoryAbbr;
	
	private String destAccountNo;
	
	private boolean isDebt;
	
	private String beneficiaryInitials;

	
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

	public String getDestAccountNo() {
		return destAccountNo;
	}

	public void setDestAccountNo(String destAccountNo) {
		this.destAccountNo = destAccountNo;
	}

	public boolean isDebt() {
		return isDebt;
	}

	public void setDebt(boolean isDebt) {
		this.isDebt = isDebt;
	}

	public String getBeneficiaryInitials() {
		return beneficiaryInitials;
	}

	public void setBeneficiaryInitials(String beneficiaryInitials) {
		this.beneficiaryInitials = beneficiaryInitials;
	}
	
}
