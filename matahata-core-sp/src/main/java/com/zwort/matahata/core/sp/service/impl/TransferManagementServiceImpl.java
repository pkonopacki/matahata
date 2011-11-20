package com.zwort.matahata.core.sp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.sp.binder.TransferManagementBinder;
import com.zwort.matahata.core.sp.dto.TransferDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.TransferManagementService;

public class TransferManagementServiceImpl extends AbstractManagementService implements TransferManagementService {

	private static final Log logger = LogFactory.getLog(TransferManagementServiceImpl.class);
	
	private TransferManagementBinder binder;
	
	@Override
	public List<Long> addNewTransfer(List<TransferDTO> dtoList) throws ServiceProviderException {
		List<Long> idsList = new ArrayList<Long>();
		
		try {
			
			for (TransferDTO dto : dtoList) {
				Long id = facade.saveTransfer(binder.bindTransferFromDto(dto)).getId();
				idsList.add(id);
			}
			
		} catch (Throwable t) {
			logger.error("TransferManagementServiceImpl.addNewTransfer failed: ", t);
			throw new ServiceProviderException("TransferManagementServiceImpl.addNewTransfer failed: ", t);
		}
		
		return idsList;

	}

	//Spring setter
	
	public void setBinder(TransferManagementBinder binder) {
		this.binder = binder;
	}
	
}
