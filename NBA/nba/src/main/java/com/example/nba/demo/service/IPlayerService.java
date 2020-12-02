package com.example.nba.demo.service;

import com.example.nba.demo.controller.nbaException.NbaException;
import com.example.nba.demo.nbaRequest.NewRequest;
import com.example.nba.demo.nbaResponse.FindResponse;
import com.example.nba.demo.nbaResponse.InjuryResponse;
import com.example.nba.demo.nbaResponse.NewResponse;
import com.example.nba.demo.nbaResponse.PlayerGameResponse;

import java.util.List;

public interface IPlayerService {


    String newPlayers(List<NewRequest> newRequest) throws NbaException;

    String deletePlayer(Integer playerID) throws NbaException;

    String editPlayer(List<Integer> playerId , Integer playerStatusId) throws Exception;

    List<InjuryResponse> injuryPlayers() throws Exception;

    String changeTeam(List<Integer> playerId, Integer teamId) throws Exception;

    String restorePlayer(Integer playerId ) throws NbaException;

    List<FindResponse> findPlayers(String playerName) throws NbaException;


    List<FindResponse> pickStarPlayers(Integer overAllScore) throws NbaException;


}
