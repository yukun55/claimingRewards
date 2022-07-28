package com.chrisyu.questclaiming.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class RewardAlreadyClaimedException extends RuntimeException{
    //Handle the exception when same reward already claimed by someone else
    public RewardAlreadyClaimedException(String message){
        super(message);
    }
}
