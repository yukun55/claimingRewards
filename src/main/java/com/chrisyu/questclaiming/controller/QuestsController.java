package com.chrisyu.questclaiming.controller;

import com.chrisyu.questclaiming.model.CompletedQuests;
import com.chrisyu.questclaiming.model.CompletedQuestsId;
import com.chrisyu.questclaiming.model.Quests;
import com.chrisyu.questclaiming.service.QuestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Date;

@RestController
public class QuestsController {
    private QuestsService questsService;

    //Constructor
    @Autowired
    public QuestsController(QuestsService questsService) {
        this.questsService = questsService;
    }

    //Handle the corresponding Http request
    @RequestMapping(value = "/quests/{questId}", method = RequestMethod.GET)
    @ResponseBody
    public Quests getQuests(@PathVariable("questId")String questId){
        return questsService.readQuests(questId);
    }

    @RequestMapping(value = "/quests", method = RequestMethod.POST)
    @ResponseBody
    public Quests setQuests(@RequestBody Quests quests){
        return questsService.addQuests(quests);
    }
}
