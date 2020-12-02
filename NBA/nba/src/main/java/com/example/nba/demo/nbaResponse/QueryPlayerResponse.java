package com.example.nba.demo.nbaResponse;

import com.example.nba.demo.model.Player;
import com.example.nba.demo.model.Status;

public class QueryPlayerResponse {

    private Integer playerId ;
    private String name;
    private String teamName;
    private String position;
    private Integer backnumber;
    private Integer score;
    private String playerStatus;


    public QueryPlayerResponse(){}

    public QueryPlayerResponse(Player player){
        this.playerId = player.getId();
        this.name = player.getName();
        this.teamName = player.getTeamName();
        this.position =player.getPosition();
        this.backnumber =player.getBacknumber();
        this.score =player.getScore();
        this.playerStatus =player.getStatus().getPlayerStatus();

    }




    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
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


    public String getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }
}
