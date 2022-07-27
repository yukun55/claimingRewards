package com.chrisyu.questclaiming.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("completedQuests")
public class CompletedQuests {
    @Id
    private CompletedQuestsId id;
    private Date completedAt;

    //Constructor
    public CompletedQuests(CompletedQuestsId id, Date completedAt) {
        this.id = id;
        this.completedAt = completedAt;
    }

    //Getter and Setter
    public CompletedQuestsId getId() {
        return id;
    }

    public void setId(CompletedQuestsId id) {
        this.id = id;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }
}
