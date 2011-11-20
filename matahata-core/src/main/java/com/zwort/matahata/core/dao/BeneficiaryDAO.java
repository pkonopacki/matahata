package com.zwort.matahata.core.dao;

import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Beneficiary;

public interface BeneficiaryDAO extends DictionaryDAO<Beneficiary> {
	
	public Beneficiary getByInitials(String name) throws DAOException;

}
