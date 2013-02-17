package com.zwort.matahata.core.substitute;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.Substitute;

import java.util.Map;

public interface SubstituteService {
	
	Substitute getSubstitute(Plan plan, Map<Expense, Double> exchangeRateMap)
			throws ServiceException;

}
