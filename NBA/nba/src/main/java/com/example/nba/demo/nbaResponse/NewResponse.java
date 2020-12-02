package com.example.nba.demo.nbaResponse;

import com.example.nba.demo.model.Detail;
import com.example.nba.demo.model.Player;
import com.example.nba.demo.model.Status;

public class NewResponse {

    private String name;
    private String teamName;
    private String position;
    private Integer backnumber;
    private Integer score;
    private Integer age;
    private String country;
    private Integer salary;
    private String playerStatus;

    public NewResponse(){}



    public NewResponse(Player player , Detail detail , Status status){
        this.name = player.getName();
        this.teamName = player.getTeamName();
        this.position = player.getPosition();
        this.backnumber = player.getBacknumber();
        this.score = player.getScore();
        this.age = detail.getAge();
        this.country = detail.getCountry();
        this.salary =detail.getSalary();
        this.playerStatus = status.getPlayerStatus();

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public String getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }
}
