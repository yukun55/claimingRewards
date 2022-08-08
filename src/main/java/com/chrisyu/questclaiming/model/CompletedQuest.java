package com.chrisyu.questclaiming.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document("completedQuests")
public class CompletedQuest {
    @Id
    private CompletedQuestId id;
    private Date completedAt;

    //Constructor
    public CompletedQuest(CompletedQuestId id, Date completedAt) {
        this.id = id;
        this.completedAt = completedAt;
    }

    //Getter and Setter
    public CompletedQuestId getId() {
        return id;
    }

    public void setId(CompletedQuestId id) {
        this.id = id;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }
}
