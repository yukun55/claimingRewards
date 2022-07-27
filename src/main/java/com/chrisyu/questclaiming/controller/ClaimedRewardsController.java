package com.chrisyu.questclaiming.controller;

import com.chrisyu.questclaiming.model.ClaimedRewards;
import com.chrisyu.questclaiming.model.ClaimedRewardsId;
import com.chrisyu.questclaiming.model.CompletedQuests;
import com.chrisyu.questclaiming.model.CompletedQuestsId;
import com.chrisyu.questclaiming.service.ClaimedRewardsService;
import com.fasterxml.jackson.databind.node.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@RestController
public class ClaimedRewardsController {
    private ClaimedRewardsService claimedRewardsService;

    //Constructor
    @Autowired
    public ClaimedRewardsController(ClaimedRewardsService claimedRewardsService) {
        this.claimedRewardsService = claimedRewardsService;
    }

    //Handle the corresponding Http request
    @RequestMapping(value = "/claimReward/{rewardId}", method = RequestMethod.POST)
    public void setClaimedRewards(@PathVariable("rewardId")String rewardId, @RequestBody ClaimedRewardsId claimedRewardsId){
        claimedRewardsService.addClaimReward(new ClaimedRewards(new ClaimedRewardsId(rewardId, claimedRewardsId.getUserId()), Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC))));
    }
}
