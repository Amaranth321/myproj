package com.ncs.kaisquare.ids.response;

public class PageResponse extends ApiResponse{

    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public PageResponse withCode(int code){
        super.withCode(code);
        return this;
    }

    public PageResponse withMessage(String message){
        super.withMessage(message);
        return this;
    }

    public PageResponse withPage(Page page){
        this.page = page;
        return this;
    }

}
