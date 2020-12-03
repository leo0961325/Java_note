package com.example.store.demo.controller;

import com.example.store.demo.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProjectController {

    @Autowired
    IProjectService iProjectService;


@PutMapping(value = "edit/user/project")
public  String editUserProject(@RequestParam List<Integer> userId ,
                               @RequestParam List<Integer> projectId,
                               @RequestParam String name) throws Exception {




    return iProjectService.editUserProject(userId  , projectId , name);
}



















}
