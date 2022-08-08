package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.QuestAlreadyCompletedException;
import com.chrisyu.questclaiming.exceptions.QuestAlreadyExistException;
import com.chrisyu.questclaiming.exceptions.QuestNotFoundException;
import com.chrisyu.questclaiming.model.CompletedQuest;
import com.chrisyu.questclaiming.model.Quest;
import com.chrisyu.questclaiming.repository.CompletedQuestRepository;
import com.chrisyu.questclaiming.repository.QuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class QuestService {
    private QuestRepository questRepository;
    private CompletedQuestRepository completedQuestRepository;

    //Constructor
    @Autowired
    public QuestService(QuestRepository questRepository, CompletedQuestRepository completedQuestRepository) {
        this.questRepository = questRepository;
        this.completedQuestRepository = completedQuestRepository;
    }

    //Add a new Quest into quest collection
    @Transactional
    public Quest addQuest(Quest quest){
        return questRepository.save(quest);
    }

    //Search a Quest from quest collection by its id
    @Transactional
    public Quest getQuest(String questId){
        Optional<Quest> questsOptional = questRepository.findById(questId);
        if(questsOptional.isPresent()){
            return questsOptional.get();
        }
        throw new QuestNotFoundException("Quest Not Found");
    }

    //Delete a exist Quest from quest collection
    @Transactional
    public String deleteQuest(String questId){
        Quest questToDelete = getQuest(questId);
        questRepository.delete(questToDelete);
        return questToDelete.getId();
    }

    //Add a new CompletedQuest to completedQuest collection
    @Transactional
    public CompletedQuest addCompletedQuest(CompletedQuest completedQuest){
        if(completedQuestRepository.existsById(completedQuest.getId())){
            throw new QuestAlreadyCompletedException("Quest already complete");
        }
        Quest setCompleteQuest = getQuest(completedQuest.getId().getQuestId());
        setCompleteQuest.setComplete(true);
        addQuest(setCompleteQuest);
        return completedQuestRepository.save(completedQuest);
    }
}
