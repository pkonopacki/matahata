package com.zwort.matahata.core.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("TRANSFER")
public class Transfer extends Item {

	private static final long serialVersionUID = -8679521341844179362L;

	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "src_account_id")
	private Account srcAccount;
	
	@ManyToOne(cascade = {CascadeType.REFRESH})
	@JoinColumn(name = "dest_account_id")
	private Account destAccount;


	public Account getSrcAccount() {
		return srcAccount;
	}

	public void setSrcAccount(Account srcAccount) {
		this.srcAccount = srcAccount;
	}
	
	public Account getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(Account destAccount) {
		this.destAccount = destAccount;
	}

}
