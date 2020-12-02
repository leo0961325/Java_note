package com.example.nba.demo.repository;

import com.example.nba.demo.model.Status;
import com.example.nba.demo.nbaResponse.FindResponse;
import com.example.nba.demo.nbaResponse.InjuryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStatusRepository extends JpaRepository <Status , Integer> {



}
