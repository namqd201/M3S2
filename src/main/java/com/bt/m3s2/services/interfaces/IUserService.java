package com.bt.m3s2.services.interfaces;

import com.bt.m3s2.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User createUser(User user);
    User updateUser(int id,  User newUser);
    void deleteUser(int id);
}
