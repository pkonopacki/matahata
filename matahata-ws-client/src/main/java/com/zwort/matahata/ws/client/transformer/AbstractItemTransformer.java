package com.zwort.matahata.ws.client.transformer;

import zwort.com.matahata.services._1.BaseRequestItem;

import com.zwort.matahata.ws.client.model.Item;
import com.zwort.matahata.ws.client.util.ConversionUtils;

public abstract class AbstractItemTransformer {
	
	public <T extends BaseRequestItem> T transformItem(Item item, T request) {
		
		request.setDate(ConversionUtils.dateToXmlGregorianCalendar(item.getDate()));
		request.setDescription(item.getDescription());
		request.setAmount(item.getAmount());
		request.setOriginalAmount(item.getOriginalAmount());
		request.setOriginalCurrencyISO(item.getOriginalCurrency());
		
		return request;
	}

}
