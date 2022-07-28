package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.Rewards;
import com.chrisyu.questclaiming.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RewardsController {

    private RewardsService rewardsService;

    //Constructor
    @Autowired
    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    //Handle the corresponding Http request
    @RequestMapping(value = "/rewards", method = RequestMethod.POST)
    @ResponseBody
    public Rewards setRewards(@RequestBody Rewards reward){
        return rewardsService.addRewards(reward);
    }
}
