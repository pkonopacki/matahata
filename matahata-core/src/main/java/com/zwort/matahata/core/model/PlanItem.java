package com.zwort.matahata.core.model;

import javax.persistence.*;

@Entity
@Table(name = "plan_item")
public class PlanItem extends AbstractBaseEntitiy {
	
	private static final long serialVersionUID = -5879398916639718292L;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	
	@Column(name = "cat_limit", nullable = false)
	private Double amount;
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
