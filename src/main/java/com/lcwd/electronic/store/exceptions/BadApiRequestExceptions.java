package com.lcwd.electronic.store.exceptions;

public class BadApiRequestExceptions extends  RuntimeException{
    public BadApiRequestExceptions(String message){
        super(message);
    }
    public BadApiRequestExceptions(){
        super("Bad Request !!");
    }
}
