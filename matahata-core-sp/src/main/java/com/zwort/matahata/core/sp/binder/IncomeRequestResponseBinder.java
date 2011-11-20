package com.zwort.matahata.core.sp.binder;

import java.util.ArrayList;
import java.util.List;

import zwort.com.matahata.services._1.AddIncomeRequest;
import zwort.com.matahata.services._1.AddIncomeRequestList;
import zwort.com.matahata.services._1.AddIncomeResponse;
import zwort.com.matahata.services._1.AddIncomeResponseList;

import com.zwort.matahata.core.sp.dto.IncomeDTO;
import com.zwort.matahata.core.sp.util.ConversionUtils;

public class IncomeRequestResponseBinder {
	
	public List<IncomeDTO> bindIncomeDtoListFromAddIncomeRequest(AddIncomeRequestList request) {
		List<IncomeDTO> dtoList = new ArrayList<IncomeDTO>();
		
		for (AddIncomeRequest req : request.getAddIncomeRequestList()) {
			IncomeDTO dto = bindIncomeDtoFromAddIncomeRequest(req);
			dtoList.add(dto);
		}
		return dtoList;
	}
	
	public IncomeDTO bindIncomeDtoFromAddIncomeRequest(AddIncomeRequest request) {
		IncomeDTO dto = new IncomeDTO();
		
		dto.setDate(ConversionUtils.xmlGregorianCalendarToDate(request.getDate()));
		dto.setDescription(request.getDescription());
		dto.setAmount(request.getAmount());
		dto.setOriginalAmount(request.getOriginalAmount());
		dto.setOriginalCurrencyISO(request.getOriginalCurrencyISO());
		
		dto.setDestAccountNo(request.getDestAccountNo());
		dto.setDebt(request.isDebt() != null ? request.isDebt() : false);
		dto.setSource(request.getSource());
		
		return dto;
	}
	
	public AddIncomeResponseList bindAddIncomeResponseList(List<Long> idsList) {
		AddIncomeResponseList response = new AddIncomeResponseList();
		List<AddIncomeResponse> responseList = new ArrayList<AddIncomeResponse>();
		
		for (Long id : idsList) {
			AddIncomeResponse resp = new AddIncomeResponse();
			resp.setId(id);
			responseList.add(resp);
		}
		response.getAddIncomeResponsesList().addAll(responseList);
		
		return response;
	}
	
	public AddIncomeResponse bindAddIncomeResponse(Long id) {
		AddIncomeResponse response = new AddIncomeResponse();
		response.setId(id);
		return response;
	}

}
