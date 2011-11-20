package com.zwort.matahata.core.sp.request;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DictionaryRequestBase extends RequestBase {
	
	@XmlElement(name = "Description", namespace = "http://www.zwort.com/matahata/")
	private String description;
	
	@XmlElement(name = "CreationDate", namespace = "http://www.zwort.com/matahata/")
	private Date creationDate;
	
	@XmlElement(name = "LastUpdate", namespace = "http://www.zwort.com/matahata/")
	private Date lastUpdate;

	@XmlElement(name = "Active", namespace = "http://www.zwort.com/matahata/")
	private Boolean active;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
}
