package com.example.nba.demo.repository;

import com.example.nba.demo.model.Player;
import com.example.nba.demo.nbaResponse.FindResponse;
import com.example.nba.demo.nbaResponse.InjuryResponse;
import com.example.nba.demo.nbaResponse.NewResponse;
import com.example.nba.demo.nbaResponse.QueryPlayerResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IPlayerRepositroy extends JpaRepository <Player , Integer> {



        Optional<Player> findAllById(Integer playerID);

        List<Player> findAllByIdIn(List<Integer> playerId);


        @Query(value = "SELECT p FROM  Player p  WHERE p.status.id = 2 ")
        List<InjuryResponse> findAllByStatus();

        @Query(value = "SELECT p FROM  Player p WHERE p.name LIKE %:playerName%   ")
        List<FindResponse> findAllByName(String playerName);


//        @Query(value = "SELECT p FROM Player p JOIN Detail d ON p.detail.Id=d.Id WHERE p.name LIKE %:name%   ")
//        List<FindResponse> findAllByName(String name);

        @Query(value = "SELECT p FROM  Player p  WHERE p.score >= :score AND p.status.id = 1 ")
        List<FindResponse> findAllByScoreIsGreaterThanEqual(Integer score);


        Player findNameById(Integer mvpId);



        Optional<Player> findByName(String name);


        List<QueryPlayerResponse> findAllByTeam_IdAndStatus_Id(Integer teamId , Integer statusId);


        List<Player> findAllByStatus_Id(Integer id);


        List<QueryPlayerResponse> findAllByTeam_Id(Integer teamId);
}
