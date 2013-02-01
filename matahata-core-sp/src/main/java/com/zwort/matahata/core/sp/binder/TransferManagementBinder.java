package com.zwort.matahata.core.sp.binder;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.model.Transfer;
import com.zwort.matahata.core.sp.dto.TransferDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import org.springframework.stereotype.Component;

@Component
public class TransferManagementBinder extends CommonBinder {
	
	public Transfer bindTransferFromDto(TransferDTO dto) throws ServiceException, ServiceProviderException {
		Transfer transfer = new Transfer();
		Currency currency = null;
		Currency originalCurrency = null;
		Account srcAccount = null;
		Account destAccount = null;
		
		srcAccount = getAccount(dto.getSrcAccount());
		destAccount = getAccount(dto.getDestAccountNo());
		
		currency = srcAccount.getCurrency();
		originalCurrency = destAccount.getCurrency();
		
		transfer.setDate(dto.getDate());
		transfer.setDescription(dto.getDescription());

		transfer.setSrcAccount(srcAccount);
		transfer.setDestAccount(destAccount);
		transfer.setCurrency(currency);
		transfer.setOriginalCurrency(originalCurrency);
		
		transfer.setAmount(getAmount(dto.getAmount()));
		transfer.setOriginalAmount(getOriginalAmount(dto.getOriginalAmount()) == 0 ? getAmount(dto.getAmount()) : getOriginalAmount(dto.getOriginalAmount()));

		return transfer;
	}
	
}
