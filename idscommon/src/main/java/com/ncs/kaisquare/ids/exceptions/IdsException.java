package com.ncs.kaisquare.ids.exceptions;

public class IdsException extends Exception{
    protected int code;

    public IdsException() {
    }

    public IdsException(String message){
        super(message);
    }

    public IdsException(int code, String message){
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
