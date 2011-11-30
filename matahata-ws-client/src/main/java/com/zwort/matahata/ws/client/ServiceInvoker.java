package com.zwort.matahata.ws.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import zwort.com.matahata.services._1.AddExpenseRequestsList;
import zwort.com.matahata.services._1.AddExpenseResponseList;
import zwort.com.matahata.services._1.AddIncomeRequestList;
import zwort.com.matahata.services._1.AddIncomeResponseList;
import zwort.com.matahata.services._1.AddTransferRequestList;
import zwort.com.matahata.services._1.AddTransferResponseList;
import zwort.com.matahata.services._1.RequestBase;
import zwort.com.matahata.services._1.ResponseBase;

import com.zwort.matahata.ws.client.model.Item;
import com.zwort.matahata.ws.client.model.ItemType;
import com.zwort.matahata.ws.client.service.MatahataService;
import com.zwort.matahata.ws.client.transformer.RequestDataFactory;
import com.zwort.matahata.ws.client.transformer.exception.TransformationException;

@Component
public class ServiceInvoker {
	
	private RequestDataFactory factory;
	
	private MatahataService service;
	
	
	public ServiceResponse invokeService(List<Item> itemsList) throws ServiceInvokerException {
		ServiceResponse resp = new ServiceResponse();
		Map<ItemType, RequestBase> paramMap = null;
		
		try {
			paramMap = factory.createMap(itemsList);
			
			//TODO: Divide methods and types
			callService(paramMap);
		} catch (TransformationException te) {
			throw new ServiceInvokerException("Service invoker failed: ", te);
		}
		//TODO: Some mapper here
		resp.setOperationCode(1);
		return resp;
	}

	private void callService(Map<ItemType, RequestBase> paramMap) {
		Map<ItemType, List<Long>> responseMap = new HashMap<ItemType, List<Long>>();
		Set<ItemType> keySet = paramMap.keySet();
//		List<Long> expIdList = new ArrayList<Long>();
//		List<Long> tranIdList = new ArrayList<Long>();
//		List<Long> incIdList = new ArrayList<Long>();
		
		for (ItemType it : keySet) {
			
			switch (it) {
			case EXPENSE:
				AddExpenseRequestsList addExpenseRequestList = converToAppropriateRequest(paramMap.get(it));
				AddExpenseResponseList responsesList = service.addNewExpense(addExpenseRequestList);
				break;
			
			case INCOME:
				AddIncomeRequestList addIncomeRequestList = converToAppropriateRequest(paramMap.get(it));
				AddIncomeResponseList responsesIncomeList = service.addNewIncome(addIncomeRequestList);
				break;
				
			case TRANSFER:
				AddTransferRequestList addTransferRequestList = converToAppropriateRequest(paramMap.get(it));
				AddTransferResponseList responsesTransferList = service.addNewTransfer(addTransferRequestList);
				break;
			
			default:
				
			}
		}
	
	}
	
//	private <T extends ResponseBase> List<Long> convertResponseToId(List<T> requestList) {
//		List<Long> returnList = new ArrayList<Long>();
//		
//		for (T response : requestList) {
//			returnList.add(response.)
//		}
//	}

	@SuppressWarnings("unchecked")
	private <T extends RequestBase> T converToAppropriateRequest(RequestBase rawRequest) {
		return (T) rawRequest;
	
	}

	//Spring setters
	
	public void setFactory(RequestDataFactory factory) {
		this.factory = factory;
	}

	public void setService(MatahataService service) {
		this.service = service;
	}
	
}
