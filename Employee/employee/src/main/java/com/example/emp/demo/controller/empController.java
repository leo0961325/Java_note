package com.example.emp.demo.controller;


import com.example.emp.demo.controller.exceptions.MesException;
import com.example.emp.demo.empRequest.EmpRequest;
import com.example.emp.demo.empRequest.PostRequest;
import com.example.emp.demo.empResponse.EmpResponse;
import com.example.emp.demo.model.EmpDB;
import com.example.emp.demo.repository.IempRepository;
import com.example.emp.demo.service.IempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class empController {

    @Autowired
    IempService iempService;

    @GetMapping(value = "hello")
    public String hello() {

        return "hello_world";
    }


    @PostMapping(value = "post")
    public EmpResponse postEmp(@Valid @RequestBody PostRequest postRequest) throws MesException {



        return iempService.post(postRequest);
    }

    @DeleteMapping(value = "delete/tem")
    public String deleteTem(@Valid @RequestParam("id") Integer id) throws MesException {


        return iempService.deleteTemp(id);
    }

    @GetMapping(value = "get_list")
    public EmpResponse getList(@Valid @RequestParam("id") Integer id) throws MesException {




        return iempService.findAllData(id);
    }

    /**
     * 回復資料
     * @param empRequest
     * @return
     * @throws MesException
     */
    @PutMapping(value = "restore")
    public String reStore(@Valid @RequestBody EmpRequest empRequest) throws MesException {



        return iempService.reStore(empRequest);
    }

    /**
     * 名字找出來模糊比對
     * @param name
     * @return
     * @throws MesException
     */
    @GetMapping(value = "find/name")
    public List<EmpResponse> findnameList(@Valid @RequestParam String name ,Integer status) throws MesException {

        return iempService.findNameList(name ,status);
    }


    /**
     * 新增一筆資料，如果沒有的話
     * @param postRequest
     * @return
     */
    @RequestMapping(value = "post/exist" , method={RequestMethod.POST,RequestMethod.PUT})
    public  String postIfEmpty(@Valid @RequestBody PostRequest postRequest) throws MesException {


        return iempService.postIfEmpty(postRequest);
    }

    @PutMapping(value = "post/exist/restore")
    public String restoreExist(@RequestParam Integer id){



        return iempService.reStoreExist(id);
    }


}
