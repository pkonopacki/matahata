package com.zwort.matahata.core.sp.binder;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.model.Beneficiary;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public class ExpenseManagementBinder extends CommonBinder {
	
	private static final Log logger = LogFactory.getLog(ExpenseManagementBinder.class);
	
	public Expense bindExpense(ExpenseDTO dto) throws ServiceException, ServiceProviderException {
		Expense expense = new Expense();
		Currency currency = null;
		Currency originalCurrency = null;
		Category category = null;
		Beneficiary beneficiary = null;
		Account account = null;
		Plan plan = null;
		
		//TODO: This all to CommonBinder!
		
		category = getCategory(dto.getCategoryAbbr());
		account = getAccount(dto.getSrcAccountNo());
		
		if (account == null) {
			logger.error("Account [" + dto.getSrcAccountNo() + "] is not in database");
			throw new ServiceProviderException("Account [" + dto.getSrcAccountNo() + "] is not in database");
		}
		
		Date expDate = null;

		if (dto.getDate() != null) {
			expDate = dto.getDate();
		
		} else {
			expDate = new Date();
		}
		plan = facade.getCurrentAccountPlan(expDate, dto.getSrcAccountNo());
		
		if (plan == null) {
			logger.error("Plan must be defined for date " + expDate);
			throw new ServiceProviderException("Plan must be defined for date " + expDate);
		}
		
		if (dto.getBeneficiaryInitials() != null && !dto.getBeneficiaryInitials().equals("")) {
			beneficiary = facade.getBeneficiaryByInitials(dto.getBeneficiaryInitials());
		
		} else {
			logger.error("Beneficiary initials cannot be null nor an empty string");
			throw new ServiceProviderException("Beneficiary initials cannot be null nor an empty string");
		}
		
		if (beneficiary == null) {
			logger.error("Beneficiary [" + dto.getBeneficiaryInitials() + "] is not in database");
			throw new ServiceProviderException("Beneficiary [" + dto.getBeneficiaryInitials() + "] is not in database");
		}
		
		currency = account.getCurrency();
		originalCurrency = getOriginalCurrency(dto.getOriginalCurrencyISO(), account);

		expense.setAmount(getAmount(dto.getAmount().doubleValue()));
		expense.setOriginalAmount(getOriginalAmount(dto.getOriginalAmount()) != 0 ? dto.getOriginalAmount() : dto.getAmount().doubleValue());
		expense.setCleared(dto.isCleared());
		expense.setRefundable(dto.isRefundable());
		expense.setCurrency(currency);
		expense.setOriginalCurrency(originalCurrency);
		expense.setCategory(category);
		expense.setSrcAccount(account);
		expense.setBeneficiary(beneficiary);
		expense.setPlan(plan);
		expense.setDate(expDate);
		expense.setLocation(dto.getLocation());
		expense.setDescription(dto.getDescription());
		
		return expense;
		
	}

}
