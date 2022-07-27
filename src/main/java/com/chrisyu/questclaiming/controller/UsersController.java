package com.chrisyu.questclaiming.controller;

import com.chrisyu.questclaiming.model.Quests;
import com.chrisyu.questclaiming.model.Users;
import com.chrisyu.questclaiming.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private UsersService usersService;

    //Constructor
    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    //Handle the corresponding Http request
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void setUsers(@RequestBody Users user){
        usersService.addUsers(user);
    }
}
