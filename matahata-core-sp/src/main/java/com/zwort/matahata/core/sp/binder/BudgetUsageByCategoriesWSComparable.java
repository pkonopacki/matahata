package com.zwort.matahata.core.sp.binder;

import java.util.Comparator;

import zwort.com.matahata.services._1.BudgetUsageByCategoriesWS;

public class BudgetUsageByCategoriesWSComparable implements
		Comparator<BudgetUsageByCategoriesWS> {

	@Override
	public int compare(BudgetUsageByCategoriesWS bubcWS1,BudgetUsageByCategoriesWS bubcWS2){
		return (bubcWS1.getAmountUsed() > bubcWS2.getAmountUsed() ? -1 : (bubcWS1.getAmountUsed() == bubcWS2.getAmountUsed() ? 0 : 1));
	}

}
