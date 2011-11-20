package com.zwort.matahata.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("DEBIT")
public class Debit extends Operation {

	private static final long serialVersionUID = 1900652539568274778L;

}
