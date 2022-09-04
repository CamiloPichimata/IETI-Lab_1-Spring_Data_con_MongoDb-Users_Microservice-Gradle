package com.escuelaing.ieti.springboot.service;

import com.escuelaing.ieti.springboot.entities.User;
import com.escuelaing.ieti.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceMongoDB implements UserService {

    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRespository) {
        this.userRepository = userRespository;
    }

    @Override
    public User create(User user) {
        if (userRepository.existsById(user.getId().toString())) {
            return null;
        } else {
            userRepository.insert(user);
            return userRepository.findById(user.getId().toString()).get();
        }
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public User update(User user, String userId) {
        return null;
    }
}
