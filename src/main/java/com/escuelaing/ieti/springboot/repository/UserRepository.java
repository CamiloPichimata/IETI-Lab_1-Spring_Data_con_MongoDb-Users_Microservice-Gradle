package com.escuelaing.ieti.springboot.repository;

import com.escuelaing.ieti.springboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findByNameOrLastName (String name, String lastName);

    List<User> findByCreatedAtAfter (String createdAt);

}
