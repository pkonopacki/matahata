package com.zwort.matahata.ws.client.transformer;

import zwort.com.matahata.services._1.AddTransferRequest;

import com.zwort.matahata.ws.client.model.Item;

public class AddTransferRequestTransformer extends AbstractItemTransformer implements
		ItemTransformer<AddTransferRequest> {

	@Override
	public AddTransferRequest transformItem(Item item) {
		AddTransferRequest request = new AddTransferRequest();
		
		transformItem(item, request);

		request.setSrcAccountNo(item.getSrcAccountNo());
		request.setDestAccountNo(item.getDestAccountNo());
		
		return request;
	}

}
