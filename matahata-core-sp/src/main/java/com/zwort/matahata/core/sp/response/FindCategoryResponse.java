package com.zwort.matahata.core.sp.response;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.zwort.matahata.core.sp.dto.CategoryDTO;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindCategoryResponse", propOrder = {
	    "transferId"
})
public class FindCategoryResponse extends ResponseBase {
	
	@XmlElement(name = "TransferId", namespace = "http://www.zwort.com/matahata")
Set<CategoryDTO> categories = new HashSet<CategoryDTO>();

	public Set<CategoryDTO> getCategories() {
		return categories;
	}
	
}
