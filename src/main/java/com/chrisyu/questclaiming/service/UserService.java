package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.exceptions.UserAlreadyExistException;
import com.chrisyu.questclaiming.model.User;
import com.chrisyu.questclaiming.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;

    //Constructor
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Add a new User into users collection
    @Transactional
    public User addUser(User user){
        return userRepository.save(user);
    }
}
