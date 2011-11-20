package com.zwort.matahata.core.dao;

import java.util.Date;
import java.util.List;

public interface EntityDAO<E> extends BaseDAO<E> {

	List<E> findByDates(Date dateFrom, Date dateTo);

}
