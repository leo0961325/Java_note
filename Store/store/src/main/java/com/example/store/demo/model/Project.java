package com.example.store.demo.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="start_time")
    private Timestamp startTime;
    @Column(name="close_time")
    private Timestamp closeTime;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="user_project",joinColumns= {@JoinColumn(name="project_id")},inverseJoinColumns= {@JoinColumn(name="user_id")})
    private List<User> users;

    //omit gets and sets

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
