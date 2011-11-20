package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Beneficiary;

public interface BeneficiaryService extends DictionaryService<Beneficiary> {

	public Beneficiary getByInitials(String initials) throws ServiceException;
	
}
