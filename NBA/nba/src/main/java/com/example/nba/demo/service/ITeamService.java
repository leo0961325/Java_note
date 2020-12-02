package com.example.nba.demo.service;

import com.example.nba.demo.controller.nbaException.NbaException;
import com.example.nba.demo.nbaRequest.GameRequest;
import com.example.nba.demo.nbaResponse.FindResponse;
import com.example.nba.demo.nbaResponse.PlayerGameResponse;
import com.example.nba.demo.nbaResponse.QueryPlayerResponse;
import com.example.nba.demo.nbaResponse.ResultResponse;

import java.util.List;

public interface ITeamService {
    ResultResponse addGameResult(GameRequest gameRequest , List<Integer> TeamId) throws NbaException;

    String editGameResult(Integer teamId , Integer win , Integer lose) throws NbaException;

    ResultResponse addGameResultById(Integer homeId , Integer guestId , Integer mvpId , Integer resultTeamId) throws NbaException;

    PlayerGameResponse modifyPlayerAndGame(List<Integer> Players,  List<Integer> gameId) throws NbaException;

    List<QueryPlayerResponse> findteamPlayers(Integer teamId , Integer statusId) throws NbaException;
}
