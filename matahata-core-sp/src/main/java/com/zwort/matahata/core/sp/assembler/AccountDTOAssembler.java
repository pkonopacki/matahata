package com.zwort.matahata.core.sp.assembler;

import java.util.ArrayList;
import java.util.List;

import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.sp.dto.AccountDTO;

public class AccountDTOAssembler {
	
	public List<AccountDTO> accountsListToDtosList(List<Account> accountsList) {
		List<AccountDTO> accDtosList = new ArrayList<AccountDTO>();
		
		for (Account account : accountsList) {
			accDtosList.add(accountToDto(account));
		}
		
		return accDtosList;
	}
	
	public AccountDTO accountToDto(Account account) {
		AccountDTO dto = new AccountDTO();
		dto.setAccountName(account.getAccountName());
		dto.setAccountNumber(account.getAccountNumber());
		dto.setBalance(account.getBalance());
		dto.setBankId(account.getBankId());
		dto.setDescription(account.getDescription());
		dto.setActive(account.isActive());
		dto.setCreationDate(account.getCreationDate());
		dto.setCurrencyISOCode(account.getCurrency().getIsoCode());
		dto.setId(account.getId());
		dto.setLastUpdate(account.getLastUpdate());
		
		return dto;
	}

}
