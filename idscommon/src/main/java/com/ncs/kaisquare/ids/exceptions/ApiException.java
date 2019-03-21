package com.ncs.kaisquare.ids.exceptions;

public class ApiException extends IdsException {

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(IdsHttpStatus.API_EXCEPTION.value(),message);
    }

    public ApiException(int code,String message) {
        super(code,message);
    }
}
