package com.example.nba.demo.controller;


import com.example.nba.demo.controller.nbaException.NbaException;
import com.example.nba.demo.nbaRequest.NewRequest;
import com.example.nba.demo.nbaResponse.FindResponse;
import com.example.nba.demo.nbaResponse.InjuryResponse;
import com.example.nba.demo.nbaResponse.NewResponse;
import com.example.nba.demo.nbaResponse.PlayerGameResponse;
import com.example.nba.demo.service.IPlayerService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {


    @Autowired
    IPlayerService iPlayerService;


    @GetMapping(value = "hello")
    public String sayhi(){


        return "hello nba";
    }


    @PostMapping(value = "add/players")
    public String newPlayers(@RequestBody List<NewRequest> newRequest) throws NbaException {




        return iPlayerService.newPlayers(newRequest);
    }


    @DeleteMapping(value = "delete/player")
    public String deletePlayer(@RequestParam Integer playerId) throws NbaException {





        return  iPlayerService.deletePlayer(playerId);
    }




    @PutMapping(value = "edit/players/Status")
    public String editPlayer(@RequestParam List<Integer> playerId , @RequestParam Integer playerStatusId) throws Exception {





        return iPlayerService.editPlayer(playerId , playerStatusId);
    }

    @GetMapping(value = "find/injury/players")
    public List<InjuryResponse> injuryPlayers () throws Exception {







        return iPlayerService.injuryPlayers();
    }

    @PutMapping(value = "change/team")
    public String changeTeam(@RequestParam List<Integer> playerId ,
                             @RequestParam Integer teamId) throws Exception {




        return  iPlayerService.changeTeam(playerId,teamId);
    }

    @PutMapping(value = "restore/player")
    public  String restorePlayer(@RequestParam Integer playerId) throws NbaException {



        return  iPlayerService.restorePlayer(playerId);
    }

    @GetMapping(value = "get/players/list")
    public List<FindResponse> findPlayers (@RequestParam String playerName) throws NbaException {




        return iPlayerService.findPlayers(playerName);
    }


    @GetMapping(value = "get/star/players")
    public List<FindResponse> pickStarPlayers(@RequestParam Integer overAllScore) throws NbaException {



        return iPlayerService.pickStarPlayers(overAllScore);
    }




}
