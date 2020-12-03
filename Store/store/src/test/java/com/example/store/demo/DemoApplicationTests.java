package com.example.store.demo;

import com.example.store.demo.model.Group;
import com.example.store.demo.model.Project;
import com.example.store.demo.model.User;
import com.example.store.demo.repository.IGroupRepository;
import com.example.store.demo.repository.IProjectRepository;
import com.example.store.demo.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IGroupRepository iGroupRepository;

    @Autowired
    IProjectRepository iProjectRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void addGroupUser(){

        User user = new User();


        user.setName("leo");
        user.setDept("Dv");
        user.setEmail("tnt@gmail.com");
        user.setPoint(8);

        User user1 = new User();

        user1.setName("sin");
        user1.setDept("dv");
        user1.setEmail("hu@exapme");
        user1.setPoint(5);

        Group group = new Group();

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        group.setUsers(users);

        //iGroupRepository.save(group);

        User userTest = new User();
        Project projectTest = new Project();

        List<User> userList = new ArrayList<>();
        List<Project> projectList = new ArrayList<>();

        userList.add(userTest);
        projectList.add(projectTest);


        userTest.setProjects(projectList);
        projectTest.setUsers(userList);


    }

    @Test
    void ManyToMany() throws ParseException {
        User user = new User();


        User user1 = new User();
        user1.setName("array");
        user1.setPoint(8);
        user1.setDept("IT");

        User user2 = new User();
        user2.setName("leo");
        user2.setPoint(5);
        user2.setDept("marketing");


        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user1);


        Project project = new Project();
        project.setName("TEST1");
        project.setId(5);
        Timestamp timestamp = Timestamp.valueOf("2020-11-23 00:00:00");
        project.setStartTime(timestamp);


        List<Project> projectList = new ArrayList<>();
        projectList.add(project);


        user.setProjects(projectList);
        project.setUsers(users);

        iProjectRepository.save(project);





    }










}
