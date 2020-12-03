package com.example.store.demo.service;


import org.springframework.stereotype.Service;

import java.util.List;


public interface IProjectService {


    String editUserProject(List<Integer> userId, List<Integer> projectId, String name) throws Exception;

}
