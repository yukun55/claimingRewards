package com.chrisyu.questclaiming.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    //Handle the exception when create duplicate users
    public UserAlreadyExistException(String message){
        super(message);
    }
}
