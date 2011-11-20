package com.zwort.matahata.core.sp.service;

import java.util.List;

import com.zwort.matahata.core.sp.dto.IncomeDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public interface IncomeManagementService {
	
	List<Long> addNewIncome(List<IncomeDTO> dto) throws ServiceProviderException;

}
