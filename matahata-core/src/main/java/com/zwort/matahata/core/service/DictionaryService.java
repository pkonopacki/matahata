package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;

import java.util.List;

public interface DictionaryService<E> extends BaseService<E> {

	List<E> findActive() throws ServiceException;

}
