package com.ncs.kaisquare.ids.exceptions;

/**
 * @author RenZongKe
 */
public class InvalidFormatException extends IdsException {

    public InvalidFormatException(String message) {
        super(IdsHttpStatus.INVALID_FORMAT.value(),message);
    }

    public InvalidFormatException(int code, String message) {
        super(code,message);
    }
}
