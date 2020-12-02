package com.example.nba.demo.model;

import org.apache.catalina.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;

    @Column(name = "teamName")
    private String teamName;
    @Column(name = "win")
    private Integer win;
    @Column(name = "lose")
    private Integer lose;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Player> players;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="team_game",joinColumns= {@JoinColumn(name="team_id")},inverseJoinColumns= {@JoinColumn(name="game_id")})
    private List<Game> games;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}