package com.escuelaing.ieti.springboot.service;

import com.escuelaing.ieti.springboot.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//@Repository
public interface UserService {

    User create(User user );

    User findById( String id );

    List<User> getAll();

    boolean deleteById( String id );

    User update(User user, String userId );


    List<User> findUsersWithNameOrLastNameLike(String queryText);

    List<User> findUsersCreatedAfter(String startDate);
}
