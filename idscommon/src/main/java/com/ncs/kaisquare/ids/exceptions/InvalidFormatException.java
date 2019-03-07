package com.ncs.kaisquare.ids.exceptions;

/**
 * @author Aye Maung
 * @since v4.4
 */
public class InvalidFormatException extends RuntimeException
{
    public InvalidFormatException(String version)
    {
        super(version);
    }
}
