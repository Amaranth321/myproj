package com.ncs.kaisquare.ids.response;

public class ApiResponse {

    protected int code;
    protected String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    protected ApiResponse withCode(int code){
        this.code = code;
        return this;
    }

    protected ApiResponse withMessage(String message){
        this.message = message;
        return this;
    }

}
