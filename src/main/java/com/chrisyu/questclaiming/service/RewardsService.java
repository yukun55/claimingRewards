package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.model.Rewards;
import com.chrisyu.questclaiming.repository.RewardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RewardsService {
    private RewardsRepository rewardsRepository;

    //Constructor
    @Autowired
    public RewardsService(RewardsRepository rewardsRepository) {
        this.rewardsRepository = rewardsRepository;
    }

    //Add a reward into rewards collection
    @Transactional
    public Rewards addRewards(Rewards reward){
        return rewardsRepository.save(reward);
    }
}
