package com.zwort.matahata.core.sp.binder;

import com.zwort.matahata.core.sp.dto.BaseDictionaryDTO;
import com.zwort.matahata.core.sp.request.DictionaryRequestBase;

public class BaseRequestResponseDictBinder extends BaseRequestResponseBinder {
	
	protected BaseDictionaryDTO bindBaseDictionaryDTO(DictionaryRequestBase request, BaseDictionaryDTO dto) {
		dto = (BaseDictionaryDTO) bindBaseDTO(request, dto);
		dto.setCreationDate(request.getCreationDate());
		dto.setLastUpdate(request.getLastUpdate());
		dto.setDescription(request.getDescription());
		dto.setActive(request.isActive());
		return dto; 
	}

}
