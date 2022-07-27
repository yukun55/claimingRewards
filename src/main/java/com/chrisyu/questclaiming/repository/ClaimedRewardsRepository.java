package com.chrisyu.questclaiming.repository;
import com.chrisyu.questclaiming.model.ClaimedRewards;
import com.chrisyu.questclaiming.model.ClaimedRewardsId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimedRewardsRepository extends MongoRepository<ClaimedRewards, ClaimedRewardsId> {

}
