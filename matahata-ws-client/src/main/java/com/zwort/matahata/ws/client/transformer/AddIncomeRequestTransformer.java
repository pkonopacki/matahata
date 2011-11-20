package com.zwort.matahata.ws.client.transformer;

import zwort.com.matahata.services._1.AddIncomeRequest;

import com.zwort.matahata.ws.client.model.Item;

public class AddIncomeRequestTransformer extends AbstractItemTransformer implements ItemTransformer<AddIncomeRequest> {

	public AddIncomeRequest transformItem(Item item) {
		AddIncomeRequest request = new AddIncomeRequest();
		
		transformItem(item, request);
		
		request.setBeneficiaryInitials(item.getBenefInitials());
		request.setDestAccountNo(item.getDestAccountNo());
		request.setSource(item.getSource());
		request.setDebt(item.getDebt());
		
		return request;
	}

}
