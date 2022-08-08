package com.chrisyu.questclaiming.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class RewardAlreadyExistException extends RuntimeException{
    //Handle the exception when create duplicate Reward
    public RewardAlreadyExistException(String message){
        super(message);
    }
}
