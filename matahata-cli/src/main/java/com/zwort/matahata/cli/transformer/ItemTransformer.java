package com.zwort.matahata.cli.transformer;

import zwort.com.matahata.services._1.BaseRequestItem;

import com.zwort.matahata.cli.model.Item;

public interface ItemTransformer<T extends BaseRequestItem> {

	T transformItem(Item item);

}
