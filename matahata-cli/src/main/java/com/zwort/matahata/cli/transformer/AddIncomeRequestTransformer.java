package com.zwort.matahata.cli.transformer;

import org.springframework.stereotype.Component;
import zwort.com.matahata.services._1.AddIncomeRequest;

import com.zwort.matahata.cli.model.Item;

@Component
public class AddIncomeRequestTransformer extends AbstractItemTransformer implements ItemTransformer<AddIncomeRequest> {

	public AddIncomeRequest transformItem(Item item) {
		AddIncomeRequest request = new AddIncomeRequest();
		
		transformItem(item, request);
		
		request.setBeneficiaryInitials(item.getBenefInitials());
		request.setDestAccountNo(item.getDestAccountNo());
		request.setSource(item.getSource());
		request.setCategoryAbbr(item.getCategoryAbbr());
		request.setDebt(item.getDebt());
		
		return request;
	}

}
