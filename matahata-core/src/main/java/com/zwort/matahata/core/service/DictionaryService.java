package com.zwort.matahata.core.service;

import java.util.List;

import com.zwort.matahata.core.exception.ServiceException;

public interface DictionaryService<E> extends BaseService<E> {

	List<E> findActive() throws ServiceException;

}
