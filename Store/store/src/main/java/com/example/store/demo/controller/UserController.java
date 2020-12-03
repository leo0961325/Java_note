package com.example.store.demo.controller;


import com.example.store.demo.controller.exceptions.DemoException;
import com.example.store.demo.model.Group;
import com.example.store.demo.service.IUserService;
import com.example.store.demo.storeRequest.GroupRequest;
import com.example.store.demo.storeRequest.UserRequest;
import com.example.store.demo.storeRequest.UserRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.MultipartConfig;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping(value = "add/user")
    public String AddUsers(@RequestBody UserRequest userRequest) {


        return iUserService.AddUsers(userRequest);
    }

    @PutMapping(value = "edit/group")
    public String editGroup(@RequestParam Integer userId, @RequestParam String name, @RequestParam Integer groupId) throws Exception {


        return iUserService.editGroup(userId, groupId, name);
    }

    @PostMapping(value = "add/group")
    public String AddGroup(@RequestParam Integer userId, @RequestParam String name) throws DemoException {


        return iUserService.addGroup(userId, name);

    }


    @PostMapping(value = "add/muti/users")
    public String addMutiUser(@RequestBody List<UserRequests> userRequests){


        return iUserService.addMutiUsers(userRequests);
    }

    @PostMapping(value = "add/muti/group")
    public String addMutiGroup(@RequestParam List<Integer> userId, @RequestParam String name) throws Exception {


        return iUserService.addMutiGroup(userId, name);
    }
}
