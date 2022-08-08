package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.CompletedQuest;
import com.chrisyu.questclaiming.model.CompletedQuestId;
import com.chrisyu.questclaiming.model.Quest;
import com.chrisyu.questclaiming.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@RestController
public class QuestController {
    private QuestService questService;

    //Constructor
    @Autowired
    public QuestController(QuestService questService) {
        this.questService = questService;
    }

    //Handle the Http request with endpoint GET /quests/{questId}
    @RequestMapping(value = "/quests/{questId}", method = RequestMethod.GET)
    public Quest getQuest(@PathVariable("questId")String questId){
        return questService.getQuest(questId);
    }

    //Handle the Http request with endpoint POST /quests
    @RequestMapping(value = "/quests", method = RequestMethod.POST)
    public Quest addQuest(@RequestBody Quest quest){
        return questService.addQuest(quest);
    }

    //Handle the Http request with endpoint DELETE /quests/{questId}
    @RequestMapping(value = "/quests/{questId}", method = RequestMethod.DELETE)
    public String deleteQuest(@PathVariable("questId")String questId){
        return questService.deleteQuest(questId);
    }

    //Handle the Http request with endpoint POST /completeQuest/{questId}
    @RequestMapping(value = "/completeQuest/{questId}", method = RequestMethod.POST)
    public CompletedQuest addCompleteQuest(@PathVariable("questId")String questId, @RequestBody CompletedQuestId completedQuestId){
        completedQuestId.setQuestId(questId);
        return questService.addCompletedQuest(new CompletedQuest(completedQuestId, Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))));
    }
}
