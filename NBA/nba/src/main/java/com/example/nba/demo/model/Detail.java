package com.example.nba.demo.model;

import com.example.nba.demo.nbaRequest.NewRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="detail")
public class Detail {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generatorName")
    @GenericGenerator(name = "generatorName", strategy = "native")
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "country")
    private String country;
    @Column(name = "salary")
    private Integer salary;


    @OneToOne(mappedBy = "detail")
    //這裡建立兩個表的關聯，並且表示自己這個類別 (Detail) 是被關聯的表
    private Player player;
//omit gets and sets


    public Detail(){}

    public Detail(NewRequest newRequest){
        this.name = newRequest.getName();
        this.age  = newRequest.getAge();
        this.country = newRequest.getCountry();
        this.salary = newRequest.getSalary();

    }




    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}