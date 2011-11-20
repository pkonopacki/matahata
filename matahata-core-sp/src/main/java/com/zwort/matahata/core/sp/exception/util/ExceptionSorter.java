package com.zwort.matahata.core.sp.exception.util;

import java.util.Set;

import com.zwort.matahata.core.sp.exception.ServiceProviderException;

public class ExceptionSorter {
	
	public static void sortExceptions(Set<String> exceptionProperties) throws ServiceProviderException {
		
		StringBuffer exceptionMessage = new StringBuffer();

		for (String message : exceptionProperties) {
			exceptionMessage.append(message);
			
			throw new ServiceProviderException(exceptionMessage.toString());
		}
		
		
	}
	
}
