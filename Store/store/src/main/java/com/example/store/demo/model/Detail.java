package com.example.store.demo.model;

import com.example.store.demo.storeRequest.UserRequest;
import com.example.store.demo.storeRequest.UserRequests;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 *  detail表
 **/
@Entity
@Table(name="detail")
public class Detail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="generatorName")
    @GenericGenerator(name = "generatorName", strategy = "native")
    private int Id;
    @Column(name="age")
    private Integer age;
    @Column(name="address")
    private String address;
    @Column(name="constellation")
    private String constellation;

    @OneToOne(mappedBy ="detail")
    //這裡建立兩個表的關聯，並且表示自己這個類別 (Detail) 是被關聯的表
    private User user;
    //omit gets and sets

    public Detail(){}

    public Detail(UserRequest userRequest){

        this.setAge(userRequest.getAge());
        this.setAddress(userRequest.getAddress());
        this.setConstellation(userRequest.getConstellation());
    }

    public Detail(UserRequests userRequests){

        this.setAge(userRequests.getAge());
        this.setAddress(userRequests.getAddress());
        this.setConstellation(userRequests.getConstellation());
    }





    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}