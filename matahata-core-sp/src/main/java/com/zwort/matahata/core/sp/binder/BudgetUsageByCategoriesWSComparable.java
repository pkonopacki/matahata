package com.zwort.matahata.core.sp.binder;

import zwort.com.matahata.services._1.BudgetUsageByCategoriesWS;

import java.util.Comparator;

public class BudgetUsageByCategoriesWSComparable implements
		Comparator<BudgetUsageByCategoriesWS> {

	@Override
	public int compare(BudgetUsageByCategoriesWS bubcWS1,BudgetUsageByCategoriesWS bubcWS2){
		return (bubcWS1.getAmountUsed() > bubcWS2.getAmountUsed() ? -1 : (bubcWS1.getAmountUsed() == bubcWS2.getAmountUsed() ? 0 : 1));
	}

}
