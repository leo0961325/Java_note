package com.example.emp.demo.repository;

import com.example.emp.demo.empRequest.EmpRequest;
import com.example.emp.demo.empResponse.EmpResponse;
import com.example.emp.demo.enums.StatusEnum;
import com.example.emp.demo.model.EmpDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IempRepository extends JpaRepository<EmpDB,Integer> {




    Optional<EmpDB> findByEmpId(String empId);

    Optional<EmpDB> findByGender(String gender);


    Optional<EmpDB> findAllById(Integer id);

    @Query(value = "SELECT e FROM  EmpDB e WHERE  e.name LIKE %:name% AND e.status = :status ")
    List<EmpResponse> findAllBYNameAndStatus(String name , StatusEnum status);
}
