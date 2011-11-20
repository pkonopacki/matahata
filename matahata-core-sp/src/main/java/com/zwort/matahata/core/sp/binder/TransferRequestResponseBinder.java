package com.zwort.matahata.core.sp.binder;

import java.util.ArrayList;
import java.util.List;

import zwort.com.matahata.services._1.AddTransferRequest;
import zwort.com.matahata.services._1.AddTransferRequestList;
import zwort.com.matahata.services._1.AddTransferResponse;
import zwort.com.matahata.services._1.AddTransferResponseList;

import com.zwort.matahata.core.sp.dto.TransferDTO;
import com.zwort.matahata.core.sp.util.ConversionUtils;

public class TransferRequestResponseBinder {

	//TODO: Try to do some abstract and maybe generics
	
	public List<TransferDTO> bindTransferDtoListFromAddTransferRequestList(AddTransferRequestList addNewTransfer) {
		List<TransferDTO> returnList = new ArrayList<TransferDTO>();
		
		for (AddTransferRequest request : addNewTransfer.getAddTransferRequestList()) {
			TransferDTO dto = bindTransferDtoFromAddTransferRequest(request);
			returnList.add(dto);
		}
		return returnList;
	}
	
	public TransferDTO bindTransferDtoFromAddTransferRequest(AddTransferRequest request) {
		TransferDTO dto = new TransferDTO();
		
		dto.setDate(ConversionUtils.xmlGregorianCalendarToDate(request.getDate()));
		dto.setDescription(request.getDescription());
		dto.setAmount(request.getAmount());
		dto.setOriginalAmount(request.getOriginalAmount());
		dto.setOriginalCurrencyISO(request.getOriginalCurrencyISO());
		
		dto.setSrcAccountNo(request.getSrcAccountNo());
		dto.setDestAccountNo(request.getDestAccountNo());
		
		return dto;
	}

	public AddTransferResponseList bindResponsesList(List<Long> idsList) {
		AddTransferResponseList response = new AddTransferResponseList();
		List<AddTransferResponse> responsesList = new ArrayList<AddTransferResponse>();
		
		for (Long id : idsList) {
			AddTransferResponse resp = bindResponse(id);
			responsesList.add(resp);
		}
		response.getAddTransferResponsesList().addAll(responsesList);
		
		return response;
	}
	
	public AddTransferResponse bindResponse(Long id) {
		AddTransferResponse resp = new AddTransferResponse();
		resp.setId(id);
		return resp;
	}

}
