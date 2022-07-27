package com.chrisyu.questclaiming.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document("users")
public class Users {
    @Id
    private String id;
    @JsonProperty("name")
    private String name;

    //Constructor
    public Users(String id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
