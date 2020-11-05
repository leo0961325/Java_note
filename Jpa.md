# About JPA

> Model.User

```java
package com.example.demo.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "user")

public class User implements Serializable {
    @Id
    private Integer id;

    @Column(name="name")
    private String name;
    @Column(name = "dept")
    private String dept;
    @Column(name = "email")
    private String email;
    @Column(name = "point")
    private int point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
```

> repository.IUserRepository (I)
``` java
package com.example.demo.demo.repository;

import com.example.demo.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {

    Optional<User> findAllById(Integer id); //找單筆



    List<UserResponse> findAll(); //找全部，並以json印出
}

```

> service.IUserService (I)
``` java
package com.example.demo.demo.service;

public interface IUserService {
    
    String get(Integer id);

    List<User> findData();
}
```

> service.UserService 
```java
package com.example.demo.demo.service.impl;

import com.example.demo.demo.model.User;
import com.example.demo.demo.repository.IUserRepository;
import com.example.demo.demo.response.UserResponse;
import com.example.demo.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository iuserRepository;

    @Override
    public String get(Integer id) {
        Optional<User> allById = iuserRepository.findAllById(id); //Optional容器 <User> =>table

        return allById.get().getName();
    }


    @Override
    public List<UserResponse> findData() {


        List<UserResponse> responses=new ArrayList<>(); //定義一個responses 的list
        List<User> findAll = iuserRepository.findAll();
        for (User user : findAll) { //初始值 : 終值
            UserResponse userResponse = new UserResponse();
            userResponse.setName(user.getName()); //把要得裝進去
            userResponse.setDept(user.getDept());
            userResponse.setEmail(user.getEmail());
            userResponse.setPoint(user.getPoint());
            responses.add(userResponse);
        }


        return responses;
    }


}

```
> Controller 層

```java
package com.example.demo.demo.controller;

import com.example.demo.demo.model.User;
import com.example.demo.demo.response.UserResponse;
import com.example.demo.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {


    @Autowired
    IUserService iUserService;


    @GetMapping(value = "user/table")
    public String user(Integer id) {


        return iUserService.get(id);



    }
    @GetMapping(value = "user/info")
    public List<UserResponse> info(){


        return iUserService.findData();
    }

}

```
