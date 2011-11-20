package com.zwort.matahata.core.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PAYMENT")
public class Payment extends Item {

	private static final long serialVersionUID = -986421358151935820L;

	@Column(name = "source")
	private String source = "";


	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
