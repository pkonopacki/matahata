package com.zwort.matahata.core.sp.dto;

public class TransferDTO extends ItemDTO {
	
	private String srcAccountNo;
	
	private String destAccountNo;

	public String getSrcAccount() {
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
	
}
