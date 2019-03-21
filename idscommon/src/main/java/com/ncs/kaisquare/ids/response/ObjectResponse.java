package com.ncs.kaisquare.ids.response;

public class ObjectResponse<T> extends ApiResponse{

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public ObjectResponse withCode(int code){
        super.withCode(code);
        return this;
    }

    public ObjectResponse withMessage(String message){
        super.withMessage(message);
        return this;
    }

    public ObjectResponse withObject(T data){
        this.data = data;
        return this;
    }
}
