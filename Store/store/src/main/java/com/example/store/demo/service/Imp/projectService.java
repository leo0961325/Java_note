package com.example.store.demo.service.Imp;

import com.example.store.demo.model.Project;
import com.example.store.demo.model.User;
import com.example.store.demo.repository.IProjectRepository;
import com.example.store.demo.repository.IUserRepository;
import com.example.store.demo.service.IProjectService;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class projectService implements IProjectService {


    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    IProjectRepository iProjectRepository;


    @Override
    public String editUserProject(List<Integer> userId, List<Integer> projectId, String name) throws Exception {


        List<User> findByUserId = iUserRepository.findAllByIdIn(userId);

        List<Project> findByProjectId = iProjectRepository.findAllByIdIn(projectId);

        /**Method 1*/
        /** userIDFromDb List 由 findBuUserId轉換*/
        List<Integer> userIdFromDb = new ArrayList<>();
        for ( User user : findByUserId ){ // User型別
            userIdFromDb.add(user.getId()); //把Integer 加入list
        }

        for (Integer uid : userId){  //找到的userid用 for迴圈一個個列出來
            if(!userIdFromDb.contains(uid)) //如果有未存在的就報錯
                throw new Exception("有USER ID不存在");
        }


        /**Method 2*/
        if(userId.size() != findByUserId.size())
            throw new Exception("有USER ID不存在");


        /**Method 3*/ /**盡量不要再動到資料庫去找*/
        for (Integer checkUserId : userId) {
            /**用 for each 將userID list轉成 一個個checkUserId*/
            /**在用Optional查看有沒有值*/
            Optional<User> userExist = iUserRepository.findAllById(checkUserId);
            if (!userExist.isPresent()) {

                throw new Exception("有USER ID不存在");
            }
        }

        /*******************************************************************/
        for (User user : findByUserId) {
            user.setProjects(findByProjectId);
        }

        for (Project project : findByProjectId) {
            for (Integer checkProjectId : projectId) {
                if (!checkProjectId.equals(project.getId())) {
                    throw new Exception("此Project ID 並無在列表中");

                }
            }
            project.setName(name);
            project.setUsers(findByUserId);

            iProjectRepository.save(project);
        }

        return "編輯user和project多對多完成";
    }


}
