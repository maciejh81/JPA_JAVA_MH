package com.capgemini.wsb.rest.exception;

public class EntityNotFoundException extends RuntimeException
{

    public EntityNotFoundException(String id)
    {
        super("Could not find entity of id " + id);
    }
}
