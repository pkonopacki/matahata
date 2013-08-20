package com.zwort.matahata.cli.transformer;

import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.AddTransferRequest;

import com.zwort.matahata.cli.model.Item;

@Component
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
