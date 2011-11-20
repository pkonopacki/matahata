package com.zwort.matahata.core.dao;

import java.util.List;

public interface DictionaryDAO<E> extends BaseDAO<E> {

	List<E> findActive(); 
	
}
