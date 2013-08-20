package com.zwort.matahata.cli.transformer;

import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.AddExpenseRequest;

import com.zwort.matahata.cli.model.Item;

@Component
public class AddExpenseRequestTransformer extends AbstractItemTransformer implements ItemTransformer<AddExpenseRequest> {

	@Override
	public AddExpenseRequest transformItem(Item item) {
		AddExpenseRequest request = new AddExpenseRequest();
		
		transformItem(item, request);
	
		request.setLocation(item.getLocation());
		request.setCategoryAbbr(item.getCategoryAbbr());
		request.setRefundable(item.getRefundable());
		request.setCleared(item.getCleared());
		request.setSrcAccountNo(item.getSrcAccountNo());
		
		request.setBeneficiaryInitials(item.getBenefInitials());
		request.setPayerInitials(item.getPayerInitials());
		
		return request;
	}

}
