package com.chrisyu.questclaiming.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("claimedRewards")
public class ClaimedRewards {

    @Id
    private ClaimedRewardsId id;

    //Constructor
    public ClaimedRewards(ClaimedRewardsId id, Date claimedAt) {
        this.id = id;
        this.claimedAt = claimedAt;
    }

    //Getter and Setter
    public ClaimedRewardsId getId() {
        return id;
    }

    public void setId(ClaimedRewardsId id) {
        this.id = id;
    }

    public Date getClaimedAt() {
        return claimedAt;
    }

    public void setClaimedAt(Date claimedAt) {
        this.claimedAt = claimedAt;
    }

    private Date claimedAt;
}
