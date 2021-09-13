package com.example.back_to_hell.controllers;

import com.example.back_to_hell.interfaces.NewUserBody;
import com.example.back_to_hell.models.UserModel;
import com.example.back_to_hell.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public @ResponseBody Iterable<UserModel> getAll() {
        return userRepository.findAll();
    }
//
//    @GetMapping("/:id")
//    public @ResponseBody Optional<UserModel> getById() {
//        return userRepository.findById(5);
//    }

    @PostMapping("/")
    public @ResponseBody
    UserModel addNew (@RequestBody NewUserBody newUserBody) {
        System.out.println(newUserBody.getEmail());
        System.out.println(newUserBody.getName());


        UserModel user = new UserModel();
        user.setName(newUserBody.getName());
        user.setEmail(newUserBody.getEmail());

        userRepository.save(user);

        return user;
    }

}