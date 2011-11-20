package com.zwort.matahata.core.sp.binder;

import org.springframework.beans.BeanUtils;

import com.zwort.matahata.core.sp.dto.AccountDTO;
import com.zwort.matahata.core.sp.request.AddAccountRequest;
import com.zwort.matahata.core.sp.response.AddAccountResponse;

public class AccountManagementBinder {
	
	public AccountDTO bindAccountDTOWithAddAccountRequest(AddAccountRequest request) {
		AccountDTO dto = new AccountDTO();
				
		BeanUtils.copyProperties(request, dto);
		
//		dto = (AccountDTO) bindBaseDictionaryDTO(request, dto);
		
//		dto.setAccountName(request.getAccountName());
//		dto.setAccountNumber(request.getAccountNumber());
//		dto.setDescription(request.getDescription());
//		dto.setActive(request.isActive());
//		dto.setBankId(request.getBankId());
//		dto.setCurrencyISOCode(request.getCurrencyISOCode());
		
		return dto;
	}
	
	public AddAccountResponse bindAddAccountResponse(Long id) {
		AddAccountResponse response = new AddAccountResponse();
		
		response.setAccountId(id);
		
		return response;
	}
	
}
