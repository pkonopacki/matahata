package com.zwort.matahata.core.sp.binder;

import java.util.List;

import org.springframework.beans.BeanUtils;

import zwort.com.matahata.services._1.AccountWSState;
import zwort.com.matahata.services._1.AccountWSStatesList;
import zwort.com.matahata.services._1.GetAccountStateResponse;

import com.zwort.matahata.core.sp.dto.AccountDTO;
import com.zwort.matahata.core.sp.request.AddAccountRequest;
import com.zwort.matahata.core.sp.response.AddAccountResponse;

public class AccountManagementRequestResponseBinder {
	

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
	
	public GetAccountStateResponse bindGetAccStateResponse(List<AccountDTO> dtosList) {
		GetAccountStateResponse response = new GetAccountStateResponse();
		AccountWSStatesList accountWSStatesList = new AccountWSStatesList();
		
		for (AccountDTO dto : dtosList) {
			AccountWSState state = bindAccountWSState(dto);
			accountWSStatesList.getAccountWSState().add(state);
		}

		response.setAccountWSStatesList(accountWSStatesList);
		
		return response;
	}

	private AccountWSState bindAccountWSState(AccountDTO dto) {
		AccountWSState accState = new AccountWSState();
		accState.setAccountNumber(dto.getAccountNumber());
		accState.setAccountState(dto.getBalance());
		
		return accState;
	}

}
