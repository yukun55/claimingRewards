package com.chrisyu.questclaiming.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClaimedRewardsId {
    @JsonIgnore
    private String rewardId;
    @JsonProperty("user_id")
    private String userId;

    //Constructor
    public ClaimedRewardsId(String rewardId, String userId) {
        this.rewardId = rewardId;
        this.userId = userId;
    }

    //Getter and Setter
    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
