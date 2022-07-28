package com.chrisyu.questclaiming.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class QuestAlreadyCompletedException extends RuntimeException{
    //Handle the exception when same quest already completed
    public QuestAlreadyCompletedException(String message){
        super(message);
    }
}
