package com.zwort.matahata.core.sp.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddAccountResponse", propOrder = {
	"accountId"
})		
public class AddAccountResponse extends ResponseBase {

	@XmlElement(name = "AccountId", namespace = "http://www.zwort.com/matahata/")
	protected Long accountId;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

}
