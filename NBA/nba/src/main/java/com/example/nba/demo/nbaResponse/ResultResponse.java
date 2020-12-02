package com.example.nba.demo.nbaResponse;

import com.example.nba.demo.model.Game;

public class ResultResponse {


    Integer gameId;
    String home;
    String guest;
    String winTeam;
    String mvp;


    public ResultResponse(Game game) {
        this.gameId = game.getId();
        this.home = game.getHome();
        this.guest = game.getGuest();
        this.winTeam = game.getWinTeam();
        this.mvp =game.getMvp();

    }


    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getGuest() {
        return guest;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public String getWinTeam() {
        return winTeam;
    }

    public void setWinTeam(String winTeam) {
        this.winTeam = winTeam;
    }

    public String getMvp() {
        return mvp;
    }

    public void setMvp(String mvp) {
        this.mvp = mvp;
    }


}
