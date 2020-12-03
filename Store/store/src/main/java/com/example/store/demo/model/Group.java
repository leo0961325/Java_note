package com.example.store.demo.model;

import com.example.store.demo.storeRequest.GroupRequest;
import com.example.store.demo.storeRequest.UserRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * group物件，Primary Key 產生策略為uuid
 * group為保留字段table應避免使用
 **/
@Entity
@Table(name="groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;

    @Column(name="name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "group")
    private List<User> users;
    //omit gets and sets

    public Group(){}

    public Group(GroupRequest groupRequest)
    {
        setId(groupRequest.getUsersId());
        setName(groupRequest.getName());
    }




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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}