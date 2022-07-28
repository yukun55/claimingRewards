package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.CompletedQuests;
import com.chrisyu.questclaiming.model.CompletedQuestsId;
import com.chrisyu.questclaiming.service.CompletedQuestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@RestController
public class CompleteQuestController {
    private CompletedQuestsService completeQuestService;

    //Constructor
    @Autowired
    public CompleteQuestController(CompletedQuestsService completeQuestService) {
        this.completeQuestService = completeQuestService;
    }

    //Handle the corresponding Http request
    @RequestMapping(value = "/completeQuest/{questId}", method = RequestMethod.POST)
    @ResponseBody
    public CompletedQuests setCompleteQuestService(@PathVariable("questId")String questId, @RequestBody CompletedQuestsId completedQuestsId){
        return completeQuestService.addCompleteQuests(new CompletedQuests(new CompletedQuestsId(completedQuestsId.getUserId(), questId), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))));
    }
}
