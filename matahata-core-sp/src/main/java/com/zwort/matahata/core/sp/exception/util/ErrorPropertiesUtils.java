package com.zwort.matahata.core.sp.exception.util;

import zwort.com.matahata.common.errorinfo._1.ErrorInfo;
import zwort.com.matahata.services._1.ResponseBase;

public class ErrorPropertiesUtils {

    public static ResponseBase setErrorInfo(ResponseBase rb, Exception e, String errorMessage) {
		String exceptionFullMessage = errorMessage + e.getCause().getMessage();
        ErrorInfo errorInfo  = new ErrorInfo();
        //TODO: To enumeration!
        errorInfo.setErrorCode(e.getClass().getName());
		errorInfo.setErrorMessage(exceptionFullMessage);
		rb.setErrorInfo(errorInfo);
		return rb;
	}

}