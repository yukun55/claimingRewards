package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.ClaimedReward;
import com.chrisyu.questclaiming.model.ClaimedRewardId;
import com.chrisyu.questclaiming.model.Reward;
import com.chrisyu.questclaiming.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@RestController
public class RewardController {

    private RewardService rewardService;

    //Constructor
    @Autowired
    public RewardController(RewardService rewardService) {
        this.rewardService = rewardService;
    }

    //Handle the Http request with endpoint POST /rewards
    @RequestMapping(value = "/rewards", method = RequestMethod.POST)
    public Reward addReward(@RequestBody Reward reward){
        return rewardService.addReward(reward);
    }

    //Handle the Http request with endpoint POST /claimReward/{rewardId}
    @RequestMapping(value = "/claimReward/{rewardId}", method = RequestMethod.POST)
    public ClaimedReward addClaimedReward(@PathVariable("rewardId")String rewardId, @RequestBody ClaimedRewardId claimedRewardId){
        return rewardService.addClaimedReward(new ClaimedReward(new ClaimedRewardId(rewardId, claimedRewardId.getUserId()), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))));
    }
}
