package com.zwort.matahata.core.sp.assembler;

import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.sp.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTOAssembler {
	
	public List<CategoryDTO> categoriesToDtos(List<Category> categoriesList) {
		//TODO: Maybe to more abstract assemblers?
		List<CategoryDTO> returnList = new ArrayList<CategoryDTO>();
		
		for (Category c : categoriesList) {
			CategoryDTO dto = categoryToDto(c);
			returnList.add(dto);
		}
		return returnList;
		
	}

	public CategoryDTO categoryToDto(Category c) {
		CategoryDTO dto = new CategoryDTO();
		dto.setAbbreviation(c.getAbbreviation());
		dto.setDescription(c.getDescription());
		//TODO: Do more...
		
		return dto;
	}

}
