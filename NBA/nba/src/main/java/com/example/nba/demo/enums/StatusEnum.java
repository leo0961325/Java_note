package com.example.nba.demo.enums;

public enum StatusEnum {

    HEALTHY("healthy"),
    INJURY("injury"),
    STOP ("Stopped");



    String playerStatus ;


    StatusEnum(String playerStatus) {
        this.playerStatus = playerStatus;

    }

    public String getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(String playerStatus) {
        this.playerStatus = playerStatus;
    }
}




