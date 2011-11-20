package com.zwort.matahata.ws.client.transformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import zwort.com.matahata.services._1.AddExpenseRequest;
import zwort.com.matahata.services._1.AddExpenseRequestsList;
import zwort.com.matahata.services._1.AddIncomeRequest;
import zwort.com.matahata.services._1.AddIncomeRequestList;
import zwort.com.matahata.services._1.AddTransferRequest;
import zwort.com.matahata.services._1.AddTransferRequestList;
import zwort.com.matahata.services._1.BaseRequestItem;
import zwort.com.matahata.services._1.RequestBase;

import com.zwort.matahata.ws.client.model.Item;
import com.zwort.matahata.ws.client.model.ItemType;
import com.zwort.matahata.ws.client.transformer.exception.TransformationException;

public class RequestDataFactory {
	
	private static final String SYSTEM = "Drucik";
	
	private AddExpenseRequestTransformer addExpenseRequestTransformer;
	
	private AddTransferRequestTransformer addTransferRequestTransformer;

	private AddIncomeRequestTransformer addIncomeRequestTransformer;

	public BaseRequestItem create (Item item, ItemType type) throws TransformationException {

		switch (type) {
		case INCOME:
			return buildRequestData(item, addIncomeRequestTransformer);
		
		case EXPENSE:
			return buildRequestData(item, addExpenseRequestTransformer);
			
		case TRANSFER:
			return buildRequestData(item, addTransferRequestTransformer);
		
		default:
			throw new TransformationException("Wrong item type");
		}
	}
	
	public Map<ItemType, RequestBase> createMap(List<Item> itemsList)  throws TransformationException {

		//TODO: To wszysch smierdzi!!!! Pomyslec!!! Kurwa!!!

		Map<ItemType, List<BaseRequestItem>> rawMap = createRawMap(itemsList);
		Map<ItemType, RequestBase> finalMap = new HashMap<ItemType, RequestBase>();
		
		Set<ItemType> keySet = rawMap.keySet();
		
		for (ItemType iType : keySet) {
			List<BaseRequestItem> itemslist = rawMap.get(iType);
			
			switch (iType) {
			
			case EXPENSE:
				AddExpenseRequestsList expRreq = new AddExpenseRequestsList();
				List<AddExpenseRequest> addExpReqList = convertBaseRequestItemList(itemslist);
				expRreq.getAddExpenseRequestsList().addAll(addExpReqList);
				expRreq.setSystem(SYSTEM);
				finalMap.put(iType, expRreq);
				break;
				
			case INCOME:
				AddIncomeRequestList incRreq = new AddIncomeRequestList();
				List<AddIncomeRequest> addIncReqList = convertBaseRequestItemList(itemslist);
				incRreq.getAddIncomeRequestList().addAll(addIncReqList);
				incRreq.setSystem(SYSTEM);
				finalMap.put(iType, incRreq);
				break;
			
			case TRANSFER:
				AddTransferRequestList trRreq = new AddTransferRequestList();
				List<AddTransferRequest> addTrReqList = convertBaseRequestItemList(itemslist);
				trRreq.getAddTransferRequestList().addAll(addTrReqList);
				trRreq.setSystem(SYSTEM);
				finalMap.put(iType, trRreq);
				break;

			default:
			}
		}
		
		return finalMap;
	}
	
	@SuppressWarnings("unchecked")
	private <T extends BaseRequestItem> List<T> convertBaseRequestItemList(List<BaseRequestItem> baseReqItsList) {
		List<T> targetList = new ArrayList<T>();
		
		for (BaseRequestItem bri : baseReqItsList) {
			T convertedItem = (T) bri;
			targetList.add(convertedItem);
		}
		
		return targetList;
	}

	public Map<ItemType, List<BaseRequestItem>> createRawMap(List<Item> itemsList) throws TransformationException {
		Map<ItemType, List<BaseRequestItem>> requestMap = new HashMap<ItemType, List<BaseRequestItem>>();
		
		for (Item i : itemsList) {
			BaseRequestItem request = this.create(i, i.getType());
			
			if (requestMap.containsKey(i.getType())) {
				List<BaseRequestItem> reqItemsList = requestMap.get(i.getType());
				reqItemsList.add(request);

			} else {
				List<BaseRequestItem> reqItemsList = new ArrayList<BaseRequestItem>();
				reqItemsList.add(request);
				requestMap.put(i.getType(), reqItemsList);
			}
		}
		return requestMap;
		
	}

	public <T extends BaseRequestItem, I extends ItemTransformer<T>> T buildRequestData(Item item, I transformer) {
		return transformer.transformItem(item);
	}

	//Spring setters
	
	public void setAddExpenseRequestTransformer(
			AddExpenseRequestTransformer addExpenseRequestTransformer) {
		this.addExpenseRequestTransformer = addExpenseRequestTransformer;
	}

	public void setAddTransferRequestTransformer(
			AddTransferRequestTransformer addTransferRequestTransformer) {
		this.addTransferRequestTransformer = addTransferRequestTransformer;
	}

	public void setAddIncomeRequestTransformer(
			AddIncomeRequestTransformer addIncomeRequestTransformer) {
		this.addIncomeRequestTransformer = addIncomeRequestTransformer;
	}
	
}
