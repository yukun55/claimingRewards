package com.chrisyu.questclaiming.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class QuestAlreadyExistException extends RuntimeException{
    //Handle the exception when create duplicate users
    public QuestAlreadyExistException(String message){
        super(message);
    }
}
