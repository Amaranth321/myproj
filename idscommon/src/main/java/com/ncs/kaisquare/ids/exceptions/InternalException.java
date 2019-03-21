package com.ncs.kaisquare.ids.exceptions;


public class InternalException extends IdsException {

    public InternalException() {
        super();
    }

    public InternalException(String message) {
        super(IdsHttpStatus.INTERNAL_EXCEPTION.value(),message);
    }

    public InternalException(int code, String message) {
        super(code,message);
    }

}
