package com.ncs.kaisquare.ids.exceptions;

/**
 * @author RenZongKe
 */
public class UnsupportedTypeException extends IdsException {

    public UnsupportedTypeException() {
        super();
    }

    public UnsupportedTypeException(String type) {
        super(IdsHttpStatus.UNSUPPORTED_TYPE.value(),type);
    }

    public UnsupportedTypeException(int code, String type) {
        super(code,type);
    }


}
