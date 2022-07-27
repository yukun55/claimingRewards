package com.chrisyu.questclaiming.repository;
import com.chrisyu.questclaiming.model.Rewards;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardsRepository extends MongoRepository<Rewards, String> {
}
