package com.jh.service;

import com.jh.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> find();

    @Transactional
    int saveUser(User user);

    @Transactional
    int deleteUser(User user);

    @Transactional
    int updateUser(User user);
}
