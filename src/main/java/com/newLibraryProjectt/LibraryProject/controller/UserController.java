package com.newLibraryProjectt.LibraryProject.controller;

import com.newLibraryProjectt.LibraryProject.dto.UserDto;
import com.newLibraryProjectt.LibraryProject.entity.User;
import com.newLibraryProjectt.LibraryProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) throws Exception{
        return userService.getUserById(id);
    }

    @PostMapping
    public UserDto saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PostMapping("search")
    public List<UserDto> searchUser(@RequestBody User user){
        return userService.searchUser(user);
    }



}
