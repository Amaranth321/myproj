package com.ncs.kaisquare.ids.exceptions;

/**
 * @author Aye Maung
 * @since v4.4
 */
public class InvalidJsonException extends Exception
{
    public InvalidJsonException()
    {
        super();
    }

    public InvalidJsonException(String file)
    {
        super(file);
    }
}
