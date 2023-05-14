package com.demo.config;

import com.demo.entities.UserEntity;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DetailService implements UserDetailsService {
    private UserService userService;

    @Autowired
    public DetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //you have to write the logic so that spring can uderstand you are a valid user
        UserEntity userEntity= userService.findByUsername(username);
        if(userEntity==null)
            throw new UsernameNotFoundException("user is not found");
        //u need to cover userEntity to the object that spring sec understand?
        return new SecUser(userEntity);
    }
}








