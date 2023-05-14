package com.demo.service;

import com.demo.entities.UserEntity;

public interface UserService {
    public UserEntity findByUsername(String username);
    public void addUserEntity(UserEntity userEntity);
}
