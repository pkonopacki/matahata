package com.zwort.matahata.core.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.zwort.matahata.core.dao.ExpenseDAO;
import com.zwort.matahata.core.model.Category;
import com.zwort.matahata.core.model.Expense;
import com.zwort.matahata.core.model.Plan;

public class ExpenseDAOJpaImpl extends EntityDAOJpaImpl<Expense> implements ExpenseDAO {

	public ExpenseDAOJpaImpl() {
		this(Expense.class);
	}

	public ExpenseDAOJpaImpl(Class<Expense> type) {
		super(type);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Expense> findOutstanding() {
		Query q = entityManager.createQuery("from Expense e where e.refundable = :refundable and e.cleared = :cleared order by e.date");
		q.setParameter("refundable", true);
		q.setParameter("cleared", false);
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Expense> findByPlan(Plan plan) {
		Query q = entityManager.createQuery("select e from Expense e inner join e.plan p where p.id = :planId order by e.date");
		q.setParameter("planId", plan.getId());
		return q.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Expense> findByPlanForCategory(Plan plan, Category category) {
		Query q = entityManager.createQuery("select e from Expense e inner join e.plan p inner join e.category c where p.id = :planId and c.id = :catId");
		q.setParameter("planId", plan.getId());
		q.setParameter("catId", category.getId());
		return q.getResultList();
	}
	
}

