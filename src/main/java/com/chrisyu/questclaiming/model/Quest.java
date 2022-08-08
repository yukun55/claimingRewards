package com.chrisyu.questclaiming.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("quests")
public class Quest {
    @Id
    private String id;
    @JsonProperty("quest_name")
    private String questName;
    @JsonProperty("quest_description")
    private String questDescription;
    @JsonProperty("completed")
    private boolean isComplete;

    //Constructor
    public Quest(String id, String questName, String questDescription, boolean isComplete) {
        this.id = id;
        this.questName = questName;
        this.questDescription = questDescription;
        this.isComplete = isComplete;
    }

    //Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
