package com.zwort.matahata.core.dao.impl;

import com.zwort.matahata.core.dao.BeneficiaryDAO;
import com.zwort.matahata.core.exception.DAOException;
import com.zwort.matahata.core.model.Beneficiary;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository(value = "beneficiaryDAO")
public class BeneficiaryDAOJpaImpl extends DictionaryDAOJpaImpl<Beneficiary>
		implements BeneficiaryDAO {


	public BeneficiaryDAOJpaImpl() {
		super(Beneficiary.class);
	}

	public BeneficiaryDAOJpaImpl(Class<Beneficiary> type) {
		super(type);
	}

	@Override
	public Beneficiary getByInitials(String initials) throws DAOException {
		Query q = entityManager.createQuery("FROM Beneficiary b WHERE b.initials = :initials");
		q.setParameter("initials", initials);
		return (Beneficiary) q.getSingleResult();
	}

}
