package com.zwort.matahata.core.sp.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddTransferResponse", propOrder = {
	    "transferId"
})
public class AddTransferResponse extends ResponseBase {

	@XmlElement(name = "TransferId", namespace = "http://www.zwort.com/matahata")
	protected Long transferId;

	public Long getTransferId() {
		return transferId;
	}

	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}
	
}
