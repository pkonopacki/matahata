package com.zwort.matahata.core.sp.service;

import java.util.List;

import com.zwort.matahata.core.sp.dto.TransferDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public interface TransferManagementService {
	
	List<Long> addNewTransfer(List<TransferDTO> dtoList) throws ServiceProviderException;

}
