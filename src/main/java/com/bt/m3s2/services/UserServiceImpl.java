package com.bt.m3s2.services;

import com.bt.m3s2.models.User;
import com.bt.m3s2.repositories.IUserRepo;
import com.bt.m3s2.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepo userRepo;


    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(int id, User newUser) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(newUser.getUsername());
        user.setEmail(newUser.getEmail());
        user.setRole(newUser.getRole());

        return userRepo.save(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepo.delete(user);

    }
}
