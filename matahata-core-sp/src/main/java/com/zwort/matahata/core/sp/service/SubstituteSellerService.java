package com.zwort.matahata.core.sp.service;

import java.util.List;

import com.zwort.matahata.core.model.Month;
import com.zwort.matahata.core.sp.dto.CriteriaDTO;
import com.zwort.matahata.core.sp.dto.ExpenseDTO;
import com.zwort.matahata.core.sp.dto.SubstituteDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public interface SubstituteSellerService {
	
	SubstituteDTO sellSubstitute(Month month, int year) throws ServiceProviderException;

	List<ExpenseDTO> findExpensesByPlanForCategory(CriteriaDTO dto) throws ServiceProviderException;
}
