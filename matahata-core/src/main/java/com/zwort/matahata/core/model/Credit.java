package com.zwort.matahata.core.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CREDIT")
public class Credit extends Operation {

	private static final long serialVersionUID = 9104884394245202236L;

}
