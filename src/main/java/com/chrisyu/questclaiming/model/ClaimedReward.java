package com.chrisyu.questclaiming.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document("claimedRewards")
public class ClaimedReward {

    @Id
    private ClaimedRewardId id;
    private Date claimedAt;

    //Constructor
    public ClaimedReward(ClaimedRewardId id, Date claimedAt) {
        this.id = id;
        this.claimedAt = claimedAt;
    }

    //Getter and Setter
    public ClaimedRewardId getId() {
        return id;
    }

    public void setId(ClaimedRewardId id) {
        this.id = id;
    }

    public Date getClaimedAt() {
        return claimedAt;
    }

    public void setClaimedAt(Date claimedAt) {
        this.claimedAt = claimedAt;
    }

}
