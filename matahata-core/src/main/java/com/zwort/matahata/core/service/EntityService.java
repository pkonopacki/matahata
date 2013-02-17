package com.zwort.matahata.core.service;

import com.zwort.matahata.core.exception.ServiceException;

import java.util.Date;
import java.util.List;

public interface EntityService<E> extends BaseService<E> {
	
	List<E> findByDates(Date dateFrom, Date dateTo) throws ServiceException;

}
