package com.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//ADMIN, MGR, EMP
public class HelloController {

    @GetMapping(path = "home")
    public String helloHome(){
        return "home data";
    }

    //only admin
    @GetMapping(path = "admin")
    public String helloAdmin(){
        return "admin data";
    }

    //only admin and mgr
    @GetMapping(path = "mgr")
    public String helloMgr() {
        return "mgr data";
    }

    //anybody admin, mgr, emp
    @GetMapping(path = "emp")
    public String helloEmp(){
        return "emp data";
    }

}
