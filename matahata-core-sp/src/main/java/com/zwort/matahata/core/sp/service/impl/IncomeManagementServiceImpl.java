package com.zwort.matahata.core.sp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.sp.binder.IncomeManagementBinder;
import com.zwort.matahata.core.sp.dto.IncomeDTO;
import com.zwort.matahata.core.sp.exception.ServiceProviderException;
import com.zwort.matahata.core.sp.service.IncomeManagementService;

public class IncomeManagementServiceImpl extends AbstractManagementService implements IncomeManagementService {

	private static final Log logger = LogFactory.getLog(IncomeManagementServiceImpl.class);
	
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

	//Spring setters
	
	public void setBinder(IncomeManagementBinder binder) {
		this.binder = binder;
	}

}