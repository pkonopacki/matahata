package com.zwort.matahata.core.sp.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddCategoryRequest", propOrder = {
    "abbreviation",
    "active",
    "description"
})
public class AddCategoryRequest {
	
	@XmlElement(name = "Abbreviation", namespace = "http://www.zwort.com/matahata/")
	private String abbreviation;
	
	@XmlElement(name = "Active", namespace = "http://www.zwort.com/matahata/")
	private boolean active;
	
	@XmlElement(name = "Description", namespace = "http://www.zwort.com/matahata/")
	private String description;

	
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
