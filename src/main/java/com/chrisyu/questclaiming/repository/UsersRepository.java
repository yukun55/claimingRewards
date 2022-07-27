package com.chrisyu.questclaiming.repository;
import com.chrisyu.questclaiming.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
}
