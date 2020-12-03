package com.example.store.demo.repository;

import com.example.store.demo.model.User;
import com.example.store.demo.storeRequest.GroupRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository <User , Integer> {
    Optional<User> findAllById(Integer Userid);




    List<User> findAllByIdIn(List<Integer> userId);
}
