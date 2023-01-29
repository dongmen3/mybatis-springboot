package com.example.mybatisspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {

    //@Autowired UserMapper userMapper;
    UserMapper userMapper;
    public UserController(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return userMapper.findUsers();
    }

    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userMapper.findUserById(id);
    }

    @RequestMapping("/updateuser/{id}")
    public void updateUserById(@RequestParam User user, @PathVariable("id") int id){
        userMapper.updateUserAddressById(user,id);
    }

}
