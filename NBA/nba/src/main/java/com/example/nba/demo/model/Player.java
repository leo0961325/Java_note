package com.example.nba.demo.model;

import com.example.nba.demo.nbaRequest.NewRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "player")
public class Player<team> implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
        @GenericGenerator(name = "auto_increment", strategy = "native")
        private Integer id;
        @Column(name="name")
        private String name;
        @Column(name = "teamName")
        private String teamName;
        @Column(name = "position")
        private String position;
        @Column(name = "backnumber")
        private Integer backnumber;
        @Column(name = "score")
        private Integer score;


        @OneToOne(cascade =CascadeType.ALL)
        @JoinColumn(name="detail_id" ,referencedColumnName="id")
        private Detail detail;


        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name="team_id")
        private Team team;

        @ManyToOne(cascade = CascadeType.MERGE)
        @JoinColumn(name="status_id")
        private Status status;



        @ManyToMany(cascade = CascadeType.MERGE)
        @JoinTable(name="player_game",joinColumns= {@JoinColumn(name="player_id")},inverseJoinColumns= {@JoinColumn(name="game_id")})
        private List<Game> games;




        public Player(){}
















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

        public Detail getDetail() {
                return detail;
        }

        public void setDetail(Detail detail) {
                this.detail = detail;
        }

        public Team getTeam() {
                return team;
        }

        public void setTeam(Team team) {
                this.team = team;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public List<Game> getGames() {
                return games;
        }

        public void setGames(List<Game> games) {
                this.games = games;
        }
}
