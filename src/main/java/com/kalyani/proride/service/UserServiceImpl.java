package com.kalyani.proride.service;


import com.kalyani.proride.model.User;
import com.kalyani.proride.repository.UserRepoImpl;
import com.kalyani.proride.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepoImpl userRepo;

    @Override
    public void registerUser(User user) {

    }
}
