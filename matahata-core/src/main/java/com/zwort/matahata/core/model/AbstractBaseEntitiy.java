package com.zwort.matahata.core.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractBaseEntitiy implements Serializable {

	private static final long serialVersionUID = 3251297152328340664L;
	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

}
