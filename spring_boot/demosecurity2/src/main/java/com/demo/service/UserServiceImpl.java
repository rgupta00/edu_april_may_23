package com.demo.service;

import com.demo.entities.UserEntity;
import com.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserEntity findByUsername(String userName) {
        return userRepo.findByUsername(userName);
    }

    @Override
    public void addUserEntity(UserEntity userEntity) {
        userRepo.save(userEntity);
    }
}



