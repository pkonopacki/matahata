package com.zwort.matahata.cli.validator;

/**
 * Created with IntelliJ IDEA.
 * User: pierre
 * Date: 7/12/12
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractValidator {

    private final static String WHITESPACE = "";

    protected static boolean isValidString(String str) {

        return str == null || str.isEmpty() ? false : true;

    }

    protected static boolean isNull(Object obj) {

        return obj == null ? false : true;

    }

}
