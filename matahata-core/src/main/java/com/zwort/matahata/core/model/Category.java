package com.zwort.matahata.core.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category extends AbstractDictionaryEntity {

	private static final long serialVersionUID = -2575942693789698542L;

	@Column(name = "abbreviation", nullable = false)
	private String abbreviation;

	@Column(name = "monthly_limit", nullable = false)
	private double monthlyLimit;
	
	@Column(name = "category_type")
	@Enumerated(EnumType.ORDINAL)
	private CategoryType categoryType;

	//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "item_category",
//			joinColumns = { @JoinColumn(name = "category_id") },
//			inverseJoinColumns = { @JoinColumn(name = "item_id") }
//	)
//	public Set<Expense> expenses; 
	
	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public double getMonthlyLimit() {
		return monthlyLimit;
	}

	public void setMonthlyLimit(double monthlyLimit) {
		this.monthlyLimit = monthlyLimit;
	}

//	public Set<Expense> getExpenses() {
//		return expenses;
//	}
//
//	public void setExpenses(Set<Expense> expenses) {
//		this.expenses = expenses;
//	}
	
	public CategoryType getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Category) {
			return this.abbreviation.equals(((Category) obj).getAbbreviation());
		
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		
		if (abbreviation == null) {
			return -1327;
		}
		
		return abbreviation.hashCode();
	}
	
}
