package com.zwort.matahata.core.sp.service;

import com.zwort.matahata.core.sp.dto.IncomeDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

import java.util.List;

public interface IncomeManagementService {
	
	List<Long> addNewIncome(List<IncomeDTO> dto) throws ServiceProviderException;

}
