package com.example.nba.demo.nbaResponse;

import com.example.nba.demo.model.Detail;
import com.example.nba.demo.model.Player;
import com.example.nba.demo.model.Status;

public class InjuryResponse {

    private Integer id ;
    private String name;
    private String teamName;
    private String position;
    private Integer backnumber;
    private Integer score;


    public InjuryResponse(){}

    public InjuryResponse(Player player){
        this.id = player.getId();
        this.name = player.getName();
        this.teamName = player.getTeamName();
        this.position = player.getPosition();
        this.backnumber = player.getBacknumber();
        this.score = player.getScore();
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
}
