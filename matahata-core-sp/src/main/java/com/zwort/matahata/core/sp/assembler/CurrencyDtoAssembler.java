package com.zwort.matahata.core.sp.assembler;

import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.sp.dto.CurrencyDTO;

public class CurrencyDtoAssembler {
	
	public CurrencyDTO currencyToDto(Currency currency) {
		//TODO: Also abstract assembler
		CurrencyDTO dto = new CurrencyDTO();
//		dto.setActive(currency.isActive());
		dto.setCurrencyIsoCode(currency.getIsoCode());
		
		return dto;
	}

}
