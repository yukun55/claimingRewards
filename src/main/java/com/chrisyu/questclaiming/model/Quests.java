package com.chrisyu.questclaiming.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("quests")
public class Quests {
    @Id
    private String id;
    @JsonProperty("quest_name")
    private String questName;
    @JsonProperty("quest_description")
    private String questDescription;

    //Constructor
    public Quests(String id, String questName, String questDescription) {
        this.id = id;
        this.questName = questName;
        this.questDescription = questDescription;
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
}
