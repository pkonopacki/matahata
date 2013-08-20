package com.zwort.matahata.cli.transformer;

import zwort.com.matahata.services._1.BaseRequestItem;

import com.zwort.matahata.cli.model.Item;
import com.zwort.matahata.cli.util.ConversionUtils;

public class AbstractTransformer {
	
	protected void fillBaseRequestData(BaseRequestItem request, Item item) {
		request.setDate(ConversionUtils.dateToXmlGregorianCalendar(item.getDate()));
		request.setDescription(item.getDescription());
		request.setAmount(item.getAmount());
		request.setOriginalAmount(item.getOriginalAmount());
		request.setOriginalCurrencyISO(item.getOriginalCurrency());
	}

}
