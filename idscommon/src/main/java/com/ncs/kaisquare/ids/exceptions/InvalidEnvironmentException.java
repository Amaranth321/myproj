package com.ncs.kaisquare.ids.exceptions;


import com.ncs.kaisquare.ids.utils.Util;

/**
 * @author Aye Maung
 */
public class InvalidEnvironmentException extends RuntimeException
{
    public InvalidEnvironmentException()
    {
        super(Util.getCallerFn() + "Ensure that the code is running in the correct environment (cloud/node)");
    }
}
