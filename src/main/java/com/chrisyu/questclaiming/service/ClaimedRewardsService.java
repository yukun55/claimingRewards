package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.RewardAlreadyClaimedException;
import com.chrisyu.questclaiming.model.ClaimedRewards;
import com.chrisyu.questclaiming.repository.ClaimedRewardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClaimedRewardsService {
    private ClaimedRewardsRepository claimedRewardsRepository;

    //Constructor
    @Autowired
    public ClaimedRewardsService(ClaimedRewardsRepository claimedRewardsRepository) {
        this.claimedRewardsRepository = claimedRewardsRepository;
    }

    //Add a claimed reward into claimedRewards collection
    @Transactional
    public ClaimedRewards addClaimReward(ClaimedRewards claimedRewards){
        if(claimedRewardsRepository.existsById(claimedRewards.getId())){
            throw new RewardAlreadyClaimedException("Reward already claimed");
        }
        return claimedRewardsRepository.save(claimedRewards);
    }

}
