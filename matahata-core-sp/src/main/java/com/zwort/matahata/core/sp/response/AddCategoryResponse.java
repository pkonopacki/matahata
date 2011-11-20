package com.zwort.matahata.core.sp.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddCategoryResponse", propOrder = {
	    "categoryId"
})
public class AddCategoryResponse extends ResponseBase {
	
	@XmlElement(name = "CategoryId", namespace = "http://www.zwort.com/matahata/")
	protected Long categoryid;

	public Long getCategoryId() {
		return categoryid;
	}

	public void setCategoryId(Long categoryid) {
		this.categoryid = categoryid;
	}
	
}
