package com.zwort.matahata.core.model;

import javax.persistence.*;

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
