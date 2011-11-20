package com.zwort.matahata.ws.client.transformer;

import zwort.com.matahata.services._1.BaseRequestItem;

import com.zwort.matahata.ws.client.model.Item;

public interface ItemTransformer<T extends BaseRequestItem> {

	T transformItem(Item item);

}
