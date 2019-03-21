package com.ncs.kaisquare.ids.exceptions;


import com.ncs.kaisquare.ids.utils.Util;

/**
 * @author RenZongKe
 */
public class InvalidEnvironmentException extends IdsException {

    public InvalidEnvironmentException() {
        super(IdsHttpStatus.INVALID_ENV.value(),Util.getCallerFn() + "Ensure that the code is running in the correct environment (cloud/node)");
    }

    public InvalidEnvironmentException(int code){
        super(code,Util.getCallerFn() + "Ensure that the code is running in the correct environment (cloud/node)");
    }

    public InvalidEnvironmentException(int code ,String message){
        super(code, message);
    }


}
