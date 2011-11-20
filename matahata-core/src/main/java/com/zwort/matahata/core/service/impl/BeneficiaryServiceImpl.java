package com.zwort.matahata.core.service.impl;

import com.zwort.matahata.core.dao.BeneficiaryDAO;
import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Beneficiary;
import com.zwort.matahata.core.service.BeneficiaryService;

public class BeneficiaryServiceImpl extends DictionaryServiceImpl<Beneficiary>
		implements BeneficiaryService{

	public BeneficiaryDAO getDao() {
		return (BeneficiaryDAO) dao;
	}

	public void setDao(BeneficiaryDAO dao) {
		this.dao = dao;
	}

	@Override
	public Beneficiary getByInitials(String initials) throws ServiceException {
		
		try {
			return getDao().getByInitials(initials);
		
		} catch (Throwable t) {
			throw new ServiceException("BeneficiaryServiceImpl#findByInitials failed: ", t);
		}
	}

}