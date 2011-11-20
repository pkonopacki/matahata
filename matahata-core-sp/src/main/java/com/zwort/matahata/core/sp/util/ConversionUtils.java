package com.zwort.matahata.core.sp.util;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConversionUtils {
	
	private static Log logger = LogFactory.getLog(ConversionUtils.class);

	public static Date xmlGregorianCalendarToDate(XMLGregorianCalendar calendar) {
		return calendar.toGregorianCalendar().getTime();
	}
	
	public static XMLGregorianCalendar dateToXmlGregorianCalendar(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		XMLGregorianCalendar xgc = null;
		
		try {
			xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		
		} catch (DatatypeConfigurationException dce) {
			logger.error("Error converting date to XmlGregorianCalendar: " + dce.getMessage());
		}
		return xgc;
	}

}
