package com.example.nba.demo.repository;

import com.example.nba.demo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGameRepository extends JpaRepository <Game ,Integer> {
    List<Game> findAllByIdIn(List<Integer> gameId);
}
