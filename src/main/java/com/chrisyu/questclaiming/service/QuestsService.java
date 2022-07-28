package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.QuestNotFoundException;
import com.chrisyu.questclaiming.model.Quests;
import com.chrisyu.questclaiming.repository.QuestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class QuestsService {
    private QuestsRepository questsRepository;

    //Constructor
    @Autowired
    public QuestsService(QuestsRepository questsRepository) {
        this.questsRepository = questsRepository;
    }

    //Add a quests into quests collection
    @Transactional
    public Quests addQuests(Quests quests){
        return questsRepository.save(quests);
    }

    //Retrieve the Quests from quests collections by its id
    @Transactional
    public Quests readQuests(String questId){
        Optional<Quests> questsOptional = questsRepository.findById(questId);
        if(questsOptional.isPresent()){
            return questsOptional.get();
        }
        throw new QuestNotFoundException("Quest Not Found");
    }
}
