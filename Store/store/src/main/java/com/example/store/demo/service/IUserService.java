package com.example.store.demo.service;

import com.example.store.demo.controller.exceptions.DemoException;
import com.example.store.demo.model.Group;
import com.example.store.demo.storeRequest.GroupRequest;
import com.example.store.demo.storeRequest.UserRequest;
import com.example.store.demo.storeRequest.UserRequests;

import java.util.List;

public interface IUserService {


    String AddUsers(UserRequest userRequest);


    String editGroup(Integer userId, Integer groupId , String name) throws Exception;

    String addGroup(Integer id, String name) throws DemoException;

    String addMutiUsers(List<UserRequests> userRequests);

    String addMutiGroup(List<Integer> userId, String name) throws Exception;
}



