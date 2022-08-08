package com.chrisyu.questclaiming.repository;
import com.chrisyu.questclaiming.model.CompletedQuest;
import com.chrisyu.questclaiming.model.CompletedQuestId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedQuestRepository extends MongoRepository<CompletedQuest, CompletedQuestId> {

}
