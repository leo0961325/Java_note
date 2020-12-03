package com.example.store.demo.service;

import com.example.store.demo.controller.exceptions.DemoException;
import com.example.store.demo.model.StoreDb;
import com.example.store.demo.storeRequest.StoreRequest;
import com.example.store.demo.storeResponse.StoreResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IStoreService {


     StoreResponse post(@RequestBody StoreRequest storeRequest) throws Exception;


     String get(Integer id) throws Exception;


     Page<StoreResponse> findbypage(@RequestParam("page") Integer page,
                                    @RequestParam("size") Integer size) throws DemoException;

    StoreResponse findAllData(Integer id) throws Exception;

     String modify (@RequestBody StoreRequest storeRequest) throws DemoException;

     String deleteTotally(@RequestParam("id") Integer id);

     String deleteTem (@RequestParam("id") Integer id);

     List<StoreResponse> findNameData (String name) throws DemoException;


    List<StoreResponse> findCodeData(String code);

    List<StoreResponse> findCodeAndNames(String name, String code);
}
