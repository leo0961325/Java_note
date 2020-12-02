package com.example.nba.demo.repository;

import com.example.nba.demo.model.Player;
import com.example.nba.demo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ITeamRepository extends JpaRepository <Team , Integer> {
    Team findAllById(Integer teamId);


    Optional<Team> findById(Integer teamId);

    List<Team> findByIdIn(List<Integer> teamIdList);
}
