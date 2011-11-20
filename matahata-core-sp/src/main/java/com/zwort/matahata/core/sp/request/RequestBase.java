package com.zwort.matahata.core.sp.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class RequestBase {

	@XmlElement(name = "Id", namespace = "http://www.zwort.com/matahata/")
	private Long id;

	@XmlElement(name = "SystemName", namespace = "http://www.zwort.com/matahata/")
	protected String systemName;
	
	@XmlElement(name = "SystemUserName", namespace = "http://www.zwort.com/matahata/")
	protected String systemUserName;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemUserName() {
		return systemUserName;
	}

	public void setSystemUserName(String systemUserName) {
		this.systemUserName = systemUserName;
	}

}
