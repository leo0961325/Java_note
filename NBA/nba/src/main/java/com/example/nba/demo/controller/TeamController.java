package com.example.nba.demo.controller;


import com.example.nba.demo.controller.nbaException.NbaException;
import com.example.nba.demo.nbaRequest.GameRequest;
import com.example.nba.demo.nbaResponse.FindResponse;
import com.example.nba.demo.nbaResponse.PlayerGameResponse;
import com.example.nba.demo.nbaResponse.QueryPlayerResponse;
import com.example.nba.demo.nbaResponse.ResultResponse;
import com.example.nba.demo.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TeamController {


    @Autowired
    ITeamService iTeamService;






    @PostMapping(value = "add/game/result")
    public ResultResponse addGameResult(@RequestBody GameRequest gameRequest ,
                                        @RequestParam List<Integer> resultTeamId) throws NbaException {




        return iTeamService.addGameResult(gameRequest , resultTeamId);
    }


    @PutMapping(value = "edit/game")
    public  String editGameResult(@RequestParam Integer teamId ,
                                  @RequestParam Integer win ,
                                  @RequestParam Integer lose) throws NbaException {




        return iTeamService.editGameResult(teamId ,win ,lose);
    }


    @PostMapping(value = "add/game/results")
    public ResultResponse addGameResults(@RequestParam Integer homeId ,
                                         @RequestParam Integer guestId ,
                                         @RequestParam Integer mvpId ,
                                         @RequestParam Integer resultTeamId) throws NbaException {




        return iTeamService.addGameResultById(homeId,guestId,mvpId, resultTeamId);
    }


    @PutMapping(value = "modify/player/games")
    public PlayerGameResponse playersAndGame(@RequestParam List<Integer> players ,
                                             @RequestParam List<Integer> gameId) throws NbaException {



        return iTeamService.modifyPlayerAndGame(players,gameId);
    }


    @GetMapping(value = "find/team/players")
    public List<QueryPlayerResponse> findTeamPlayers(@RequestParam Integer teamId,
                                                     @RequestParam Integer statusId) throws NbaException {


        return iTeamService.findteamPlayers(teamId,statusId);
    }





































}
