package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.QuestAlreadyCompletedException;
import com.chrisyu.questclaiming.model.CompletedQuests;
import com.chrisyu.questclaiming.model.CompletedQuestsId;
import com.chrisyu.questclaiming.repository.CompletedQuestsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CompletedQuestsServiceTest {
    @Autowired
    private CompletedQuestsService completedQuestsService;

    @Autowired
    private CompletedQuestsRepository completedQuestsRepository;

    @Test
    public void addExistedCompletedQuestsThrowsException() {
        CompletedQuests quests = new CompletedQuests(new CompletedQuestsId("1", "1"), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        completedQuestsRepository.save(quests);
        assertThrows(QuestAlreadyCompletedException.class, () -> {
            completedQuestsService.addCompleteQuests(quests);
        });
    }

    @Test
    public void addNewCompletedQuestsToCollection() {
        CompletedQuests quests = new CompletedQuests(new CompletedQuestsId("2", "1"), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        completedQuestsRepository.save(quests);
        CompletedQuests questsToTest = new CompletedQuests(new CompletedQuestsId("2", "2"), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        completedQuestsService.addCompleteQuests(questsToTest);
        assertTrue(completedQuestsRepository.existsById(new CompletedQuestsId("2", "2")));
    }
}
