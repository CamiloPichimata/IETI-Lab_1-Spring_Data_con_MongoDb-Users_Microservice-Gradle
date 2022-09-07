package com.escuelaing.ieti.springboot.service;

import com.escuelaing.ieti.springboot.entities.User;
import com.escuelaing.ieti.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
            Optional<User> userTemp = userRepository.findById(user.getId().toString());
            return userTemp.orElse(null);
        }
    }

    @Override
    public User findById(String id) {
        Optional<User> userTemp = userRepository.findById(id);
        return userTemp.orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public User update(User user, String userId) {
        if (userRepository.existsById(userId)) {
            return userRepository.save(user);
        } else {
            return null;
        }
    }
}
