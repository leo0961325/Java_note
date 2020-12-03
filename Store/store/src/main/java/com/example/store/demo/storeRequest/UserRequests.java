package com.example.store.demo.storeRequest;

import com.example.store.demo.model.User;

import java.util.List;

public class UserRequests {
    /**
     * 包裝成list
     */
    List<UserRequest> UserRequests;


    String name;
    String dept;
    String email;
    int point;
    Integer age;
    String address;
    String constellation;
    List<User> users;


    public List<UserRequest> getUserRequests() {
        return UserRequests;
    }

    public void setUserRequests(List<UserRequest> userRequests) {
        UserRequests = userRequests;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }