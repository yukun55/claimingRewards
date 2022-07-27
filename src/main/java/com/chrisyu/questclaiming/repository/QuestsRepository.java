package com.chrisyu.questclaiming.repository;
import com.chrisyu.questclaiming.model.Quests;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestsRepository extends MongoRepository<Quests, String> {

}
