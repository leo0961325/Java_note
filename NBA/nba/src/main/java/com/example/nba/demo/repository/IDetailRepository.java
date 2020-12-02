package com.example.nba.demo.repository;

import com.example.nba.demo.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailRepository extends JpaRepository <Detail , Integer> {
}
