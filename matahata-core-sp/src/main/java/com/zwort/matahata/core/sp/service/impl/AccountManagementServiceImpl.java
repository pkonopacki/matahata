package com.zwort.matahata.core.sp.service.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Account;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.service.AccountService;
import com.zwort.matahata.core.service.CurrencyService;
import com.zwort.matahata.core.sp.dto.AccountDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.AccountManagementService;

public class AccountManagementServiceImpl implements AccountManagementService {
	
	//TODO: validation numbers, unique stuff, etc
	
	private static final Log logger = LogFactory.getLog(AccountManagementServiceImpl.class);
	
	private CurrencyService currencyService;
	private AccountService accountService;

	@Override
	public Long addNewAccount(AccountDTO dto) throws ServiceProviderException {
		Account account = new Account();
		Currency currency = null;
		
		try {

			Date creationDate = new Date();
			
			if (dto.getCreationDate() != null) {
				creationDate = dto.getCreationDate();
			}
			account.setCreationDate(creationDate);
			
			Date lastUpdate = new Date();

			if (dto.getLastUpdate() != null) {
				lastUpdate = dto.getLastUpdate();
			}
			account.setLastUpdate(lastUpdate);
			account.setBalance(0d);
			
			if (dto.getCurrencyISOCode() != null && !dto.getCurrencyISOCode().equals("")) {
				currency = currencyService.getByIsoCode(dto.getCurrencyISOCode());
			
			} else {
				currency = currencyService.getReferenceCurrency();
			}
			
			if (currency == null) {
				logger.error("No currencies available");
				throw new ServiceProviderException("No currencies available");
			}
			
			account.setCurrency(currency);
			
			Long bankId = null;
			
			if (dto.getBankId() != null) {
				bankId = dto.getBankId();
			}
			account.setBankId(bankId);
			
			boolean active = false; 
			
			if (dto.isActive() != null) {
				active = dto.isActive();
			
			} 
			account.setActive(active);
			account.setDescription(dto.getDescription());
			
			if (dto.getAccountNumber() != null) {
				Account acc = accountService.getByNumber(dto.getAccountNumber());
				
				if (acc != null) {
					logger.error("Account number [" + acc + "] alredy exists");
					throw new ServiceProviderException("Account number [" + acc + "] alredy exists");
				}
			
			} else {
				logger.error("Account number cannot be null");
				throw new ServiceProviderException("Account number cannot be null");
			}
			account.setAccountNumber(dto.getAccountNumber());
			account.setAccountName(dto.getAccountName());
			
			return accountService.add(account).getId();
		
		} catch (ServiceException se) {
			logger.error("AccountManagementServiceImpl.addNewAccount failed: ", se);
			throw new ServiceProviderException("AccountManagementServiceImpl.addNewAccount failed: ", se);	
		}
	
	}

	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
