package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.QuestNotFoundException;
import com.chrisyu.questclaiming.model.Quests;
import com.chrisyu.questclaiming.repository.QuestsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuestsServiceTest {
    @Autowired
    private QuestsService questsService;
    @Autowired
    private QuestsRepository questsRepository;

    @Test
    public void notFoundQuestsThrowsException(){
        Quests quests = new Quests(UUID.randomUUID().toString(), "Hit 100 points", "My quest");
        questsRepository.save(quests);
        assertThrows(QuestNotFoundException.class, ()->{
            questsService.readQuests(UUID.randomUUID().toString());
        });
    }

    @Test
    public void foundQuestsReturnCorrespondingQuests(){
        String questId = UUID.randomUUID().toString();
        Quests quests = new Quests(questId, "Hit 100 points", "My quest");
        questsRepository.save(quests);
        Quests questToCompare = questsService.readQuests(questId);
        assertEquals(quests.getId(), questToCompare.getId());
        assertEquals(quests.getQuestName(), questToCompare.getQuestName());
        assertEquals(quests.getQuestDescription(), questToCompare.getQuestDescription());
    }


}
