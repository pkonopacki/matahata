package com.zwort.matahata.core.sp.config;

public class StatsConfigBeanImpl implements StatsConfig {

	private Integer monthFirstDay;
	
	private Integer monthLastDay;

	@Override
	public Integer getMonthFirstDay() {
		return this.monthFirstDay;
	}

	@Override
	public Integer getMonthLastDay() {
		return this.monthLastDay;
	}

	@Override
	public CalculationMode getDefaultMode() {
		return CalculationMode.MONTH;
	}
	
	//Spring setters

	public void setMonthFirstDay(Integer monthFirstDay) {
		this.monthFirstDay = monthFirstDay;
	}

	public void setMonthLastDay(Integer monthLastDay) {
		this.monthLastDay = monthLastDay;
	}


	public enum CalculationMode {
		DAY,
		WEEK,
		MONTH
	}

}
