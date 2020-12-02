package com.example.nba.demo.nbaResponse;

import com.example.nba.demo.model.Game;
import com.example.nba.demo.model.Player;

import java.util.Collections;
import java.util.List;

public class PlayerGameResponse {

    String homeTeam;
    String GuestTeam;


    public PlayerGameResponse(){}

    public PlayerGameResponse(Game game){
        this.homeTeam = game.getHome();
        this.GuestTeam = game.getGuest();


    }



    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getGuestTeam() {
        return GuestTeam;
    }

    public void setGuestTeam(String guestTeam) {
        GuestTeam = guestTeam;
    }

}
