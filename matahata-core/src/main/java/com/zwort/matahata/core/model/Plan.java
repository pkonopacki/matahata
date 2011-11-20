package com.zwort.matahata.core.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OBJECT_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("PLAN")
public class Plan extends AbstractBaseEntitiy {

	private static final long serialVersionUID = -8513527576297010281L;
	
	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "plan_item_link",
				joinColumns = { @JoinColumn(name = "plan_id") },
				inverseJoinColumns = { @JoinColumn(name = "plan_Item_id") })
	private Set<PlanItem> planItemsList;
	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Set<PlanItem> getPlanItemsList() {
		
		if (planItemsList == null) {
			planItemsList = new HashSet<PlanItem>();
		}
		
		return planItemsList;
	}

}