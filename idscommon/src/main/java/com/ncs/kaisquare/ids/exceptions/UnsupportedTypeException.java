package com.ncs.kaisquare.ids.exceptions;

/**
 * @author Aye Maung
 * @since v4.4
 */
public class UnsupportedTypeException extends RuntimeException
{
    public UnsupportedTypeException()
    {
        super();
    }

    public UnsupportedTypeException(String type)
    {
        super(type);
    }
}
