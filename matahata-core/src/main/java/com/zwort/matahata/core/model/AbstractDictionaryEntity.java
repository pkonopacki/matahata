package com.zwort.matahata.core.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractDictionaryEntity extends AbstractBaseEntitiy {

	private static final long serialVersionUID = -124738895361684902L;

	@Column(name = "description")
	private String description;
	
	@Column(name = "creation_date")
	private Date creationDate;
	
	@Column(name = "last_update")
	private Date lastUpdate;

	@Column(name = "active", nullable = false)
	private boolean active;

	
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
