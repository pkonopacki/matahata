package com.zwort.matahata.core.sp.binder;

import com.zwort.matahata.core.model.Month;
import com.zwort.matahata.core.sp.dto.BaseDTO;
import com.zwort.matahata.core.sp.request.RequestBase;

public class BaseRequestResponseBinder {
	
	protected BaseDTO bindBaseDTO(RequestBase base, BaseDTO dto) {
		dto.setId(base.getId());
		return dto;
	}

	public Month bindMonthFromWSMonth(zwort.com.matahata.services._1.Month wsMonth) {
		Month month = null;
		
		switch (wsMonth) {
		
		case JANUARY:
			month = Month.MONTH_1;
			break;
			
		case FEBRUARY:
			month = Month.MONTH_2;
			break;
			
		case MARCH:
			month = Month.MONTH_3;
			break;
			
		case APRIL:
			month = Month.MONTH_4;
			break;
			
		case MAY:
			month = Month.MONTH_5;
			break;
			
		case JUNE:
			month = Month.MONTH_6;
			break;
			
		case JULY:
			month = Month.MONTH_7;
			break;
			
		case AUGUST:
			month = Month.MONTH_8;
			break;
			
		case SEPTEMBER:
			month = Month.MONTH_9;
			break;
			
		case OCTOBER:
			month = Month.MONTH_10;
			break;
			
		case NOVEMBER:
			month = Month.MONTH_11;
			break;
			
		case DECEMBER:
			month = Month.MONTH_12;
			break;
			
		default:
			month = Month.MONTH_1;
		}
		
		return month;
	}
	
}
