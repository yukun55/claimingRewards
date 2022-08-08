package com.chrisyu.questclaiming.controller;
import com.chrisyu.questclaiming.model.User;
import com.chrisyu.questclaiming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    //Constructor
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Handle the Http request with endpoint POST /users
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
