package com.example.emp.demo.service;

import com.example.emp.demo.controller.exceptions.MesException;
import com.example.emp.demo.empRequest.EmpRequest;
import com.example.emp.demo.empRequest.PostRequest;
import com.example.emp.demo.empResponse.EmpResponse;

import java.util.List;

public interface IempService {
    EmpResponse post(PostRequest postRequest) throws MesException;

    String deleteTemp(Integer id) throws MesException;

    EmpResponse findAllData(Integer id) throws MesException;

    String reStore(EmpRequest empRequest) throws MesException;

    List<EmpResponse> findNameList(String name ,Integer status) throws MesException;

    String postIfEmpty(PostRequest postRequest) throws MesException;

    String reStoreExist(Integer id);
}
