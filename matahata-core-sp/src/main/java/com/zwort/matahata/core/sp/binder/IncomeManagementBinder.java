package com.zwort.matahata.core.sp.binder;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.model.Income;
import com.zwort.matahata.core.sp.dto.IncomeDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public class IncomeManagementBinder extends CommonBinder {

	public Income bindIncomeFromDto(IncomeDTO dto) throws ServiceException, ServiceProviderException {
		Income income = new Income();
		Account destAccount = getAccount(dto.getDestAccountNo());
		Currency currency = destAccount.getCurrency();
		Currency originalCurrency = getOriginalCurrency(dto.getOriginalCurrencyISO(), destAccount);
		//TODO: mMaybe this..
		//		Beneficiary beneficiary = getBeneficiaryByInitials(dto.getBeneficiaryInitials());
		
		income.setDate(dto.getDate());
		income.setDescription(dto.getDescription());
		income.setSource(dto.getSource());

		income.setDestAccount(destAccount);
		income.setCurrency(currency);
		income.setOriginalCurrency(originalCurrency);

		income.setAmount(getAmount(dto.getAmount()));
		income.setOriginalAmount(getOriginalAmount(dto.getOriginalAmount()) == 0 ? getAmount(dto.getAmount()) : getOriginalAmount(dto.getOriginalAmount()));
		
		return income;
	}
}
