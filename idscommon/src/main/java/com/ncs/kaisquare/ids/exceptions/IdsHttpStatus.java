package com.ncs.kaisquare.ids.exceptions;

public enum IdsHttpStatus {

    API_EXCEPTION(100),
    INTERNAL_EXCEPTION(101),
    DEVICE_NOT_FOUND(102),
    INVALID_ENV(103),
    INVALID_FORMAT(104),
    INVALID_JSON(105),
    UNSUPPORTED_TYPE(106);

    private int code;

    private IdsHttpStatus(int code){
        this.code = code;
    }

    public int value(){
        return this.code;
    }
}
