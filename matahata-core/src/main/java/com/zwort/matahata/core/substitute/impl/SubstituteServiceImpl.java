package com.zwort.matahata.core.substitute.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zwort.matahata.core.exception.ServiceException;
import com.zwort.matahata.core.model.BudgetUsageForCategory;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Currency;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;
import com.zwort.matahata.core.model.PlanItem;
import com.zwort.matahata.core.model.Substitute;
import com.zwort.matahata.core.substitute.SubstituteService;

public class SubstituteServiceImpl implements SubstituteService {

	private static final Log logger = LogFactory.getLog(SubstituteServiceImpl.class);

	
	@Override
	public Substitute getSubstitute(Plan plan, Map<Expense, Double> exchangeRateMap) throws ServiceException {
		Set<Expense> expensesList = exchangeRateMap.keySet();
		logger.debug("SubstituteServiceImpl#getSubstitute start" + expensesList.size());
		Substitute substitute = new Substitute();
//		Double totals = new Double(0);
		
		logger.debug("SubstituteServiceImpl#getSubstitute expenses.size(): " + expensesList.size());
		Map<Currency, Double> totalsMap = new HashMap<Currency, Double>();
		Map<Category, Map<Currency, Double>> expensesByCategoryMap = new HashMap<Category, Map<Currency,Double>>();
		Map<Currency, Double> expByCurrMap = null;
		
		for (Expense exp : expensesList) {
			
			logger.debug("SubstituteServiceImpl#getSubstitute id:" + exp.getId());
			logger.debug("SubstituteServiceImpl#getSubstitute cat:" + exp.getCategory().getDescription());
			logger.debug("SubstituteServiceImpl#getSubstitute iamount" + exp.getAmount());
			logger.debug("SubstituteServiceImpl#getSubstitute curr:" + exp.getCurrency().getIsoCode());

			if (totalsMap.containsKey(exp.getCurrency())) {
				Double totals = totalsMap.get(exp.getCurrency());
				totals += exp.getAmount();
				totalsMap.put(exp.getCurrency(), totals);
			
			} else {
				totalsMap.put(exp.getCurrency(), exp.getAmount());
			}

			if (expensesByCategoryMap.containsKey(exp.getCategory())) {
				
				logger.debug("SubstituteServiceImpl#getSubstitute expensesByCategoryMap.containsKey(exp.getCategory(): true");
				
				expByCurrMap = expensesByCategoryMap.get(exp.getCategory());
				
				if (expByCurrMap.containsKey(exp.getCurrency())) {

					logger.debug("SubstituteServiceImpl#getSubstitute expByCurrMap.containsKey(exp.getCurrency()): true");
					
					Double expSumForCat = expByCurrMap.get(exp.getCurrency());

					logger.debug("SubstituteServiceImpl#getSubstitute expSumForCat: " + expSumForCat.doubleValue());

					expSumForCat += exp.getAmount();

					logger.debug("SubstituteServiceImpl#getSubstitute expSumForCat: " + expSumForCat.doubleValue());
					
					expByCurrMap.put(exp.getCurrency(), expSumForCat);
				
				} else {
					
					logger.debug("SubstituteServiceImpl#getSubstitute expByCurrMap.containsKey(exp.getCurrency()): false");

					expByCurrMap.put(exp.getCurrency(), exp.getAmount());
				}
				
			} else {
				
				logger.debug("SubstituteServiceImpl#getSubstitute expensesByCategoryMap.containsKey(exp.getCategory()): false");

				expByCurrMap = new HashMap<Currency, Double>();
				expByCurrMap.put(exp.getCurrency(), exp.getAmount());
			}
			expensesByCategoryMap.put(exp.getCategory(), expByCurrMap);
			
		}
		logger.debug("SubstituteServiceImpl#getSubstitute expensesByCategoryMap.size(): " + expensesByCategoryMap.size());
		substitute.setExpensesByCategoriesMap(expensesByCategoryMap);
		substitute.setPlan(plan);
		substitute.setTotalsMap(totalsMap);
		logger.debug("SubstituteServiceImpl#getSubstitute end");
		
		Set<BudgetUsageForCategory> budgetUsageList = generateBudgetUsageList(plan, exchangeRateMap);
		logger.debug("SubstituteServiceImpl#getSubstitute budgetUsageList.size(): " + budgetUsageList.size());
		
		substitute.getBudgetForCategoriesList().addAll(budgetUsageList);
		
		return substitute;
	}

	private Set<BudgetUsageForCategory> generateBudgetUsageList(Plan plan, Map<Expense, Double> exchangeRateMap) {
		Set<BudgetUsageForCategory> budgetUsageForCategoryList= new HashSet<BudgetUsageForCategory>();
		logger.debug("SubstituteServiceImpl#generateBudgetUsageList PlanItemsList.size(): " + plan.getPlanItemsList().size());
		
		for (PlanItem item : plan.getPlanItemsList()) {
			BudgetUsageForCategory budUsageForCat = createUsageForCategory(item, exchangeRateMap);
			logger.debug("SubstituteServiceImpl#generateBudgetUsageList Adding BudgetUsageForCategory: " + budUsageForCat.getCategory().getAbbreviation() + ", " + budUsageForCat.getBudgetAmount() + ", " + budUsageForCat.getSpentTillNow());
			budgetUsageForCategoryList.add(budUsageForCat);
		}
		
		return budgetUsageForCategoryList;
	}

	private BudgetUsageForCategory createUsageForCategory(PlanItem item,
			Map<Expense, Double> exchangeRateMap) {
		BudgetUsageForCategory budUsageForCat = new BudgetUsageForCategory();
		budUsageForCat.setCategory(item.getCategory());
		budUsageForCat.setBudgetAmount(item.getAmount());
		Double spentTillNow = getExpensesForCatFromMap(item.getCategory(), exchangeRateMap);
		budUsageForCat.setSpentTillNow(spentTillNow);
		
		return budUsageForCat;
	}

	private Double getExpensesForCatFromMap(Category category,
			Map<Expense, Double> exchangeRateMap) {
		Set<Expense> keySet = exchangeRateMap.keySet();
		Double spentTillNow = new Double(0);

		for (Expense exp : keySet) {
			
			if (exp.getCategory().equals(category)) {
				Double addition = exchangeRateMap.get(exp) == 0 ? exp.getAmount() : exp.getAmount() * exchangeRateMap.get(exp);
				spentTillNow += addition;
			}
		}
		
		return spentTillNow;
	}
	
}