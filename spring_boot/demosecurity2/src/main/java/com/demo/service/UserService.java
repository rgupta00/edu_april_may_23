package com.demo.service;

import com.demo.entities.UserEntity;

public interface UserService {
    public UserEntity findByUsername(String userName);
    public void  addUserEntity(UserEntity userEntity);
}
