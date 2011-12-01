package com.zwort.matahata.core.sp.binder;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.facade.Facade;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.model.Beneficiary;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.model.Month;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public abstract class CommonBinder {
	
	protected Facade facade;
	
	private static final Log logger = LogFactory.getLog(CommonBinder.class);

	protected Account getAccount(String accountNumber) throws ServiceException, ServiceProviderException {
		Account account = null;
		
		if (accountNumber != null && !accountNumber.equals("")) {
			account = facade.getAccountByNumber(accountNumber);
		
		} else {
			logger.error("Account number cannot be null nor an empty string");
			throw new ServiceProviderException("Account number cannot be null nor an empty string");
		}
		return account;
		
	}
	
	protected Currency getOriginalCurrency(String originalCurrencyISO, Account account) throws ServiceException, ServiceProviderException {
		Currency originalCurrency = null;
		
		if (originalCurrencyISO != null && !originalCurrencyISO.equals("")) {
			originalCurrency = facade.getCurrencyByIsoCode(originalCurrencyISO);
		
		} else {
			originalCurrency = account.getCurrency();
		}
		return originalCurrency;
				
	}
	
	protected Double getAmount(Double amount) throws ServiceException, ServiceProviderException {

		if (amount == null) {
			logger.error("Amount cannot be null");
			throw new ServiceProviderException("Amount cannot be null");
		}
		return amount; 
		
	}
	
	protected Double getOriginalAmount(Double originalAmount) {
		return originalAmount != null ? originalAmount : new Double(0);
	}
	
	protected Beneficiary getBeneficiaryByInitials(String initials) throws ServiceException, ServiceProviderException {
		Beneficiary beneficiary = null;
		
		if (initials != null && !initials.equals("")) {
			beneficiary = facade.getBeneficiaryByInitials(initials);
		
		} else {
			logger.error("Beneficiary initials cannot be null nor an empty string");
			throw new ServiceProviderException("Beneficiary initials cannot be null nor an empty string");
		}
		return beneficiary;
		
	}
	
	protected void isCategoryAbbreviationUnique(String abbr) throws ServiceException, ServiceProviderException {

		if (abbr != null
				&& !abbr.equals("")) {
			Category cat = facade.getCategoryByAbbr(abbr);

			if (cat != null) {
				logger.error("Category with abbreviation ["
						+ abbr + "] alredy exists");
				throw new ServiceProviderException(
						"Category with abbreviation ["
								+ abbr + "] alredy exists");
			}

		} else {
			logger.error("Abbreviation cannod be null nor an empty string");
			throw new ServiceProviderException(
					"Abbreviation cannot be null nor an empty string");
		}
		
	}
	
	protected Date getFirstDayOfMonth(Month month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, month.ordinal());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		
		return cal.getTime();
	}

	protected Date getLastDayOfMonth(Month month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.MONTH, month.ordinal());
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		
		return cal.getTime();
	}
	
	protected Category getCategory(String categoryAbbr) throws ServiceException, ServiceProviderException {
		Category category = null;
		
		if (categoryAbbr != null && !categoryAbbr.equals("")) {
			category = facade.getCategoryByAbbr(categoryAbbr);
		
		} else {
			logger.error("Category abbreviation cannot be null nor an empty string");
			throw new ServiceProviderException("Category abbreviation cannot be null nor an empty string");
		}
		
		return category;
	}

	//Spring setter
	
	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
}
