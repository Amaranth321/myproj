package com.ncs.kaisquare.ids.exceptions;

/**
 * @author RenZongKe
 */
public class InvalidJsonException extends IdsException {

    public InvalidJsonException()
    {
        super();
    }

    public InvalidJsonException(String message) {
        super(IdsHttpStatus.INVALID_JSON.value(),message);
    }

    public InvalidJsonException(int code,String message){
        super(code,message);
    }
}
