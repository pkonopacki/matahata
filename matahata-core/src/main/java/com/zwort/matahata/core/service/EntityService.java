package com.zwort.matahata.core.service;

import java.util.Date;
import java.util.List;

import com.zwort.matahata.core.exception.ServiceException;

public interface EntityService<E> extends BaseService<E> {
	
	List<E> findByDates(Date dateFrom, Date dateTo) throws ServiceException;

}
