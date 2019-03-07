package com.ncs.kaisquare.ids.response;

import java.util.List;

public class ListResponse<T> extends ApiResponse{

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public ListResponse withCode(int code){
        super.withCode(code);
        return this;
    }

    public ListResponse withMessage(String message){
        super.withMessage(message);
        return this;
    }

    public ListResponse withList(List<T> list){
        this.list = list;
        return this;
    }
}
