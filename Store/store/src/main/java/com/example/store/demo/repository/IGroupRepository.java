package com.example.store.demo.repository;

import com.example.store.demo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGroupRepository extends JpaRepository <Group , Integer> {


    Group findAllById(Integer id);

    List<Group> findAllByName(String name);
}
