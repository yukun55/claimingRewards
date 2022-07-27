package com.chrisyu.questclaiming.exceptions;

public class RewardAlreadyClaimedException extends RuntimeException{
    //Handle the exception when same reward already claimed by someone else
    public RewardAlreadyClaimedException(String message){
        super(message);
    }
}
