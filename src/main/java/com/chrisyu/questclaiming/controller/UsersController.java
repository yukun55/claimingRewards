package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.Users;
import com.chrisyu.questclaiming.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public Users setUsers(@RequestBody Users user){
        return usersService.addUsers(user);
    }
}
