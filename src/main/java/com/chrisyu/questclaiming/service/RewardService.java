package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.RewardAlreadyClaimedException;
import com.chrisyu.questclaiming.exceptions.RewardNotFoundException;
import com.chrisyu.questclaiming.model.ClaimedReward;
import com.chrisyu.questclaiming.model.Reward;
import com.chrisyu.questclaiming.repository.ClaimedRewardRepository;
import com.chrisyu.questclaiming.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class RewardService {
    private ClaimedRewardRepository claimedRewardRepository;
    private RewardRepository rewardRepository;

    //Constructor
    @Autowired
    public RewardService(ClaimedRewardRepository claimedRewardRepository, RewardRepository rewardRepository) {
        this.claimedRewardRepository = claimedRewardRepository;
        this.rewardRepository = rewardRepository;
    }

    //Add a new Reward to rewards collection
    @Transactional
    public Reward addReward(Reward reward){
        return rewardRepository.save(reward);
    }

    @Transactional
    public Reward getReward(String rewardId){
        Optional<Reward> rewardOptional = rewardRepository.findById(rewardId);
        if(rewardOptional.isPresent()){
            return rewardOptional.get();
        }
        throw new RewardNotFoundException("Reward Not Found");
    }

    //Add a ClaimedReward to claimedReward collection
    @Transactional
    public ClaimedReward addClaimedReward(ClaimedReward claimedReward){
        if(claimedRewardRepository.existsById(claimedReward.getId())){
            throw new RewardAlreadyClaimedException("Reward already claimed");
        }
        Reward setClaimedReward = getReward(claimedReward.getId().getRewardId());
        setClaimedReward.setClaim(true);
        addReward(setClaimedReward);
        return claimedRewardRepository.save(claimedReward);
    }
}
