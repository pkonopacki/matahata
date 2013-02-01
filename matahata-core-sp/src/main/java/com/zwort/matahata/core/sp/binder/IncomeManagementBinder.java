package com.zwort.matahata.core.sp.binder;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.model.Income;
import com.zwort.matahata.core.sp.dto.IncomeDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class IncomeManagementBinder extends CommonBinder {

	private static final Log logger = LogFactory.getLog(IncomeManagementBinder.class);

	
	public Income bindIncomeFromDto(IncomeDTO dto) throws ServiceException, ServiceProviderException {
		Income income = new Income();
		Account destAccount = getAccount(dto.getDestAccountNo());
		Currency currency = destAccount.getCurrency();
		Currency originalCurrency = getOriginalCurrency(dto.getOriginalCurrencyISO(), destAccount);
		Category category = getCategory(dto.getCategoryAbbr());
		//TODO: mMaybe this..
		//		Beneficiary beneficiary = getBeneficiaryByInitials(dto.getBeneficiaryInitials());
		
		if (category == null) {
			logger.error("Category [" + dto.getCategoryAbbr() + "] is not in database");
			throw new ServiceProviderException("Category [" + dto.getCategoryAbbr() + "] is not in database");
		}
		
		income.setDate(dto.getDate());
		income.setDescription(dto.getDescription());
		income.setSource(dto.getSource());
		income.setIncomeCategory(category);

		income.setDestAccount(destAccount);
		income.setCurrency(currency);
		income.setOriginalCurrency(originalCurrency);

		income.setAmount(getAmount(dto.getAmount()));
		income.setOriginalAmount(getOriginalAmount(dto.getOriginalAmount()) == 0 ? getAmount(dto.getAmount()) : getOriginalAmount(dto.getOriginalAmount()));
		
		return income;
	}
}
