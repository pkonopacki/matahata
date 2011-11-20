package com.zwort.matahata.core.substitute;

import java.util.List;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.Substitute;

public interface SubstituteService {
	
	Substitute getSubstitute(Plan plan, List<Expense> expenses)
			throws ServiceException;

}
