package com.example.nba.demo.enums;

public enum ErrorEnum {


    ERROR_EXISTED_PLAYER("this player already existed"),
    ERROR_NOTFOUND_PLAYER("can`t find the player"),
    ERROR_NOTFOUND_TEAM ("can`t find the Team"),
    ERROR_STATUS("ERROR Entry","This player is healthy!"),
    ERROR_SCORE("Over All SCORE total is 100"),
    ERROR_ENTER("Your Enter content is wrong"),
    ERROR_GAME_ID("Can`t find this game"),
    ERROR_EMPTY("Your request is null"),
    ERROR_UNHEALTHY_PLAYER("ERROR Entry","This player is Unhealthy!"),
    ERROR_PLAYER_IN_GAME("Player not in this game")
    ;

    String code;

    String message;

    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorEnum(String code){

        this.code = code;
    }



    public String getCode(){

        return this.code;
    }



}
