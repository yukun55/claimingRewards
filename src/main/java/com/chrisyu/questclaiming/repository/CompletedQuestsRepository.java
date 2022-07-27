package com.chrisyu.questclaiming.repository;
import com.chrisyu.questclaiming.model.CompletedQuests;
import com.chrisyu.questclaiming.model.CompletedQuestsId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedQuestsRepository extends MongoRepository<CompletedQuests, CompletedQuestsId> {

}
