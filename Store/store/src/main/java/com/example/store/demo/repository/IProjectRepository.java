package com.example.store.demo.repository;

import com.example.store.demo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends JpaRepository <Project , Integer> {




    Optional<Project> findAllById(Integer projectId);


    List<Project> findAllByIdIn(List<Integer> projectId);
}
