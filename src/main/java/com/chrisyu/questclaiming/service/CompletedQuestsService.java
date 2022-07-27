package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.QuestAlreadyCompletedException;
import com.chrisyu.questclaiming.model.CompletedQuests;
import com.chrisyu.questclaiming.repository.CompletedQuestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompletedQuestsService {
    private CompletedQuestsRepository completedQuestsRepository;

    //Constructor
    @Autowired
    public CompletedQuestsService(CompletedQuestsRepository completedQuestsRepository) {
        this.completedQuestsRepository = completedQuestsRepository;
    }

    //Add a completed quests into completedQuests collection
    @Transactional
    public void addCompleteQuests(CompletedQuests completedQuests){
        if(completedQuestsRepository.existsById(completedQuests.getId())){
            throw new QuestAlreadyCompletedException("Quest already complete");
        }
        completedQuestsRepository.save(completedQuests);
    }
}
