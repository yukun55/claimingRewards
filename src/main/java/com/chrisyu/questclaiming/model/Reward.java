package com.chrisyu.questclaiming.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("rewards")
public class Reward {
    @Id
    private String id;
    private double amount;
    @JsonProperty("claimed")
    private boolean isClaim;

    //Constructor
    public Reward(String id, double amount, boolean isClaim) {
        this.id = id;
        this.amount = amount;
        this.isClaim = isClaim;
    }

    //Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isClaim() {
        return isClaim;
    }

    public void setClaim(boolean claim) {
        isClaim = claim;
    }
}
