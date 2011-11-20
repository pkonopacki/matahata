package com.zwort.matahata.core.sp.config;

import com.zwort.matahata.core.sp.config.StatsConfigBeanImpl.CalculationMode;

public interface StatsConfig {
	
	public Integer getMonthFirstDay();
	
	public Integer getMonthLastDay();

	public CalculationMode getDefaultMode();
	
}
