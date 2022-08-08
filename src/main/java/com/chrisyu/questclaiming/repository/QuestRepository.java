package com.chrisyu.questclaiming.repository;
import com.chrisyu.questclaiming.model.Quest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestRepository extends MongoRepository<Quest, String> {

}
