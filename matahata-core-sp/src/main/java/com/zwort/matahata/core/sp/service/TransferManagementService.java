package com.zwort.matahata.core.sp.service;

import com.zwort.matahata.core.sp.dto.TransferDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

import java.util.List;

public interface TransferManagementService {
	
	List<Long> addNewTransfer(List<TransferDTO> dtoList) throws ServiceProviderException;

}
