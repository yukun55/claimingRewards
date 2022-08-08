package com.chrisyu.questclaiming.repository;
import com.chrisyu.questclaiming.model.ClaimedReward;
import com.chrisyu.questclaiming.model.ClaimedRewardId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimedRewardRepository extends MongoRepository<ClaimedReward, ClaimedRewardId> {

}
