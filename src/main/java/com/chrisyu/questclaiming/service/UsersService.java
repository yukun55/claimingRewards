package com.chrisyu.questclaiming.service;
import com.chrisyu.questclaiming.model.Users;
import com.chrisyu.questclaiming.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {
    private UsersRepository usersRepository;

    //Constructor
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    //Add a user into users collection
    @Transactional
    public Users addUsers(Users user){
        return usersRepository.save(user);
    }
}
