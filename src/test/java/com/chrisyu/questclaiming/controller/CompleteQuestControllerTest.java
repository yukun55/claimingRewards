package com.chrisyu.questclaiming.controller;

import com.chrisyu.questclaiming.service.CompletedQuestsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompleteQuestControllerTest {
    @Autowired
    private CompletedQuestsService completedQuestsService;
    @Autowired
    private CompleteQuestController completeQuestController;

    @Test
    public void questCompleteWithSameResponseBody(){

    }
}
