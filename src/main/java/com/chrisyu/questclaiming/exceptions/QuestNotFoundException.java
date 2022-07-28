package com.chrisyu.questclaiming.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class QuestNotFoundException extends RuntimeException{
    //Handle the exception when quest not found
    public QuestNotFoundException(String message){
        super(message);
    }
}
