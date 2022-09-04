package com.escuelaing.ieti.springboot.repository;

import com.escuelaing.ieti.springboot.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
