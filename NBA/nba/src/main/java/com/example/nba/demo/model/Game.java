package com.example.nba.demo.model;

import com.example.nba.demo.nbaRequest.GameRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator="auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private int id;
    @Column(name="home")
    private String home;
    @Column(name="guest")
    private String guest;
    @Column(name="winTeam")
    private String winTeam;
    @Column(name="MVP")
    private String mvp;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="player_game",joinColumns= {@JoinColumn(name="game_id")},inverseJoinColumns= {@JoinColumn(name="player_id")})
    private List<Player> players;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="team_game",joinColumns= {@JoinColumn(name="game_id")},inverseJoinColumns= {@JoinColumn(name="team_id")})
    private List<Team> teams;



    public Game(){}

    public Game (GameRequest gameRequest){
        this.home = gameRequest.getHome();
        this.guest = gameRequest.getGuest();
        this.winTeam =gameRequest.getWinTeam();
        this.mvp = gameRequest.getMvp();


    }





    





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}