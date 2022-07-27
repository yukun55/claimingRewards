package com.chrisyu.questclaiming.exceptions;

public class QuestAlreadyCompletedException extends RuntimeException{
    //Handle the exception when same quest already completed
    public QuestAlreadyCompletedException(String message){
        super(message);
    }
}
