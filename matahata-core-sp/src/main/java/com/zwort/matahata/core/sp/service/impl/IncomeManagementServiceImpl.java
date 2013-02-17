package com.zwort.matahata.core.sp.service.impl;

import com.zwort.matahata.core.sp.binder.IncomeManagementBinder;
import com.zwort.matahata.core.sp.dto.IncomeDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.IncomeManagementService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class IncomeManagementServiceImpl extends AbstractManagementService implements IncomeManagementService {

	private static final Log logger = LogFactory.getLog(IncomeManagementServiceImpl.class);
	
	@Inject
    private IncomeManagementBinder binder;
	
	@Override
	public List<Long> addNewIncome(List<IncomeDTO> dtoList) throws ServiceProviderException {
		List<Long> idsList = new ArrayList<Long>();
		
		try {
			
			for (IncomeDTO dto : dtoList) {
				Long id = facade.saveIncome(binder.bindIncomeFromDto(dto)).getId();
				idsList.add(id);
			}
			
		} catch (Throwable t) {
			logger.error("IncomeManagementServiceImpl.addNewIncome failed: ", t);
			throw new ServiceProviderException("IncomeManagementServiceImpl.addNewIncome failed: ", t);
		}
		
		return idsList;
		
	}

}