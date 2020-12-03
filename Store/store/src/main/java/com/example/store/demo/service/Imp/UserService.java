package com.example.store.demo.service.Imp;

import com.example.store.demo.controller.exceptions.DemoException;
import com.example.store.demo.enums.DemoEnum;
import com.example.store.demo.model.Detail;
import com.example.store.demo.model.Group;
import com.example.store.demo.model.User;
import com.example.store.demo.repository.IGroupRepository;
import com.example.store.demo.repository.IUserRepository;
import com.example.store.demo.service.IUserService;
import com.example.store.demo.storeRequest.UserRequest;
import com.example.store.demo.storeRequest.UserRequests;
import com.sun.corba.se.spi.orbutil.threadpool.NoSuchThreadPoolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IGroupRepository iGroupRepository;

    @Autowired
    IUserRepository iUserRepository;

    /**
     * 新增 user資料 一對多
     *
     * @param userRequest
     * @return
     */
    @Override
    public String AddUsers(UserRequest userRequest) {

        User user = new User(userRequest);
        Group group = new Group();


        List<User> users = new ArrayList<>();
        users.add(user);

        //group.setName(userRequest.getName());
        group.setUsers(users);
        /**
         * SET Detail ID
         */
        Detail detail = new Detail(userRequest);
        user.setDetail(detail);


        iGroupRepository.save(group);

        return "新增完成";
    }

    /**
     * 修改 user至group 中
     *
     * @param
     * @return
     */
    @Override
    public String editGroup(Integer userId, Integer groupId, String name) throws Exception {
        Optional<User> findId = iUserRepository.findAllById(userId);

        if (!findId.isPresent()) {
            throw new Exception("");
        }

        User user = findId.get();


        /***如果指向NULL那麼將不會有值*/

        Group group = iGroupRepository.findAllById(groupId);

        user.setGroup(group);
        group.setName(name);
        iUserRepository.save(user);

        return "修改群組完成";
    }

    /**
     * 單筆新增Group群組
     *
     * @param id
     * @param name
     * @return
     * @throws DemoException
     */
    @Override
    public String addGroup(Integer id, String name) throws DemoException {
        Optional<User> findId = iUserRepository.findAllById(id);
        Group group = new Group();


        if (!findId.isPresent()) {
            throw new DemoException(DemoEnum.ERROR_MES3, "Id不存在");
        }
        User user = findId.get();


        user.setGroup(group);
        group.setName(name);

        iGroupRepository.save(group);


        return "新增群組完成";
    }

    /**
     * 新增多筆request in table
     *
     * @param userRequests
     * @return
     */
    @Override
    public String addMutiUsers(List<UserRequests> userRequests) {


        for (UserRequests userRequests1 : userRequests) {
            User user = new User();
            Group group = new Group();


            Detail detail = new Detail();
            detail.setAge(userRequests1.getAge());
            detail.setConstellation(userRequests1.getConstellation());
            detail.setAddress(userRequests1.getAddress());


            List<User> users = new ArrayList<>();
            users.add(user);


            user.setName(userRequests1.getName());
            user.setDept(userRequests1.getDept());
            user.setEmail(userRequests1.getEmail());
            user.setPoint(userRequests1.getPoint());

            /**
             * Set in table
             */
            group.setUsers(users);
            user.setGroup(group);
            user.setDetail(detail);


            iGroupRepository.save(group);
        }

        return "新增多筆完成";
    }

    /**
     * 新增多筆  List<User> Id in Group
     *
     * @param userId
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public String addMutiGroup(List<Integer> userId, String name) throws Exception {
        List<User> findById = iUserRepository.findAllByIdIn(userId);
        Group group = new Group(); //全部都指向同一個group id

        if (findById.isEmpty()) {
            throw new Exception("找無此User ID");
        }

        for (User user : findById) {
            /**
             *在User有自身所屬的 Group ID
             */



            user.setGroup(group);

            group.setName(name);

            iGroupRepository.save(group);
        }


        return "新增群組完成";
    }

}
