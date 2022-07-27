package com.chrisyu.questclaiming.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("rewards")
public class Rewards {
    @Id
    private String id;
    private Double amount;

    //Constructor
    public Rewards(String id, Double amount) {
        this.id = id;
        this.amount = amount;
    }

    //Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
