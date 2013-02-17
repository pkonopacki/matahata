package com.zwort.matahata.core.sp.service.impl;

import com.zwort.matahata.core.sp.binder.TransferManagementBinder;
import com.zwort.matahata.core.sp.dto.TransferDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.TransferManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class TransferManagementServiceImpl extends AbstractManagementService implements TransferManagementService {

	private static final Log logger = LogFactory.getLog(TransferManagementServiceImpl.class);
	
	@Inject
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

}
