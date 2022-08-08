package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.QuestAlreadyCompletedException;
import com.chrisyu.questclaiming.exceptions.QuestNotFoundException;
import com.chrisyu.questclaiming.model.CompletedQuest;
import com.chrisyu.questclaiming.model.CompletedQuestId;
import com.chrisyu.questclaiming.model.Quest;
import com.chrisyu.questclaiming.repository.CompletedQuestRepository;
import com.chrisyu.questclaiming.repository.QuestRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class QuestServiceTest {
    @Autowired
    private QuestService questService;
    @Autowired
    private QuestRepository questRepository;
    @Autowired
    private CompletedQuestRepository completedQuestRepository;

    @Test
    @DisplayName("Test Should Pass When QuestService Context Successfully Load")
    public void shouldLoadContext() throws Exception {
        // we test that our QuestService is not null
        assertThat(questService).isNotNull();
    }

    @Test
    @DisplayName("Test Should Pass When Add New Quest")
    public void shouldPassWhenAddNewQuest(){
        Quest quest = new Quest(null, "", "", false);
        Quest questToCompare = questService.addQuest(quest);
        assertEquals(quest.getId(), questToCompare.getId());
        assertEquals(quest.getQuestName(), questToCompare.getQuestName());
        assertEquals(quest.getQuestDescription(), questToCompare.getQuestDescription());
    }

    @Test
    @DisplayName("Test Should Pass When Found Quest By Id")
    public void shouldPassWhenFoundQuestById(){
        String questId = UUID.randomUUID().toString();
        Quest quest = new Quest(questId, "", "",false);
        questRepository.save(quest);
        Quest questToCompare = questService.getQuest(questId);
        assertEquals(quest.getId(), questToCompare.getId());
        assertEquals(quest.getQuestName(), questToCompare.getQuestName());
        assertEquals(quest.getQuestDescription(), questToCompare.getQuestDescription());
    }

    @Test
    @DisplayName("Test Should Throws Exception When Quest Not Found By Id")
    public void shouldThrowsExceptionWhenNotFoundQuestById(){
        assertThrows(QuestNotFoundException.class, ()->{
            questService.getQuest(UUID.randomUUID().toString());
        });
    }

    @Test
    @DisplayName("Test Should Pass When Deleted Quest By Id")
    public void shouldPassWhenDeletedQuestById(){
        String questId = UUID.randomUUID().toString();
        Quest quest = new Quest(questId, "", "", false);
        questRepository.save(quest);
        String questIdToCompare = questService.deleteQuest(questId);
        assertEquals(questId, questIdToCompare);
    }

    @Test
    @DisplayName("Test Should Throws Exception When Delete Quest Not Found By Id")
    public void shouldThrowsExceptionWhenDeleteNotFoundQuestById(){
        assertThrows(QuestNotFoundException.class, ()->{
            questService.deleteQuest(UUID.randomUUID().toString());
        });
    }

    @Test
    @DisplayName("Test Should Pass When Add New CompletedQuest")
    public void shouldPassWhenAddNewCompletedQuestAndFoundCompletedQuestById() {
        String questId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        questRepository.save(new Quest(questId, "","",false));
        CompletedQuestId completedQuestId = new CompletedQuestId(userId, questId);
        CompletedQuest completedQuest = new CompletedQuest(completedQuestId , Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        CompletedQuest completedQuestToCompare = questService.addCompletedQuest(completedQuest);
        assertEquals(completedQuest.getId(), completedQuestToCompare.getId());
        assertEquals(completedQuest.getCompletedAt(), completedQuestToCompare.getCompletedAt());
    }

    @Test
    @DisplayName("Test Should Throws Exception When Add Existed CompletedQuest")
    public void shouldThrowsExceptionWhenAddExistedCompletedQuest() {
        CompletedQuest quest = new CompletedQuest(new CompletedQuestId(UUID.randomUUID().toString(), UUID.randomUUID().toString()), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        completedQuestRepository.save(quest);
        assertThrows(QuestAlreadyCompletedException.class, () -> {
            questService.addCompletedQuest(quest);
        });
    }

    @Test
    @DisplayName("Test Should Set Quest Completed To True After Add To CompletedQuest Collection")
    public void shouldSetQuestCompleted(){
        String questId = UUID.randomUUID().toString();
        String userId = UUID.randomUUID().toString();
        questRepository.save(new Quest(questId, "","",false));
        CompletedQuest completedQuest = new CompletedQuest(new CompletedQuestId(userId, questId), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        questService.addCompletedQuest(completedQuest);
        assertTrue(questService.getQuest(questId).isComplete());
    }
}
