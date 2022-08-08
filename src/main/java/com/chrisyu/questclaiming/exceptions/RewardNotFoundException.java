package com.chrisyu.questclaiming.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RewardNotFoundException extends RuntimeException{
    //Handle the exception when Reward not found
    public RewardNotFoundException(String message){
        super(message);
    }
}
