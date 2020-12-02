package com.example.nba.demo.nbaRequest;

import com.example.nba.demo.model.Status;
import com.sun.istack.NotNull;

public class NewRequest {

    @NotNull
    private String name;
    @NotNull
    private String position;
    @NotNull
    private Integer backnumber;
    @NotNull
    private Integer score;
    @NotNull
    private Integer age;
    @NotNull
    private String country;
    @NotNull
    private Integer salary;
    @NotNull
    private Integer teamId;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getBacknumber() {
        return backnumber;
    }

    public void setBacknumber(Integer backnumber) {
        this.backnumber = backnumber;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
