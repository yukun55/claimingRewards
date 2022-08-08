package com.chrisyu.questclaiming.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CompletedQuestId {
    @JsonProperty("user_id")
    private String userId;
    @JsonIgnore
    private String questId;

    //Constructor
    public CompletedQuestId(String userId, String questId) {
        this.userId = userId;
        this.questId = questId;
    }

    //Getter and Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestId() {
        return questId;
    }

    public void setQuestId(String questId) {
        this.questId = questId;
    }
}
