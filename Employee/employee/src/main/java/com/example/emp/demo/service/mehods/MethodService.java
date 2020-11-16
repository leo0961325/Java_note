package com.example.emp.demo.service.mehods;

import com.example.emp.demo.controller.exceptions.MesException;
import com.example.emp.demo.enums.DeptEnum;
import com.example.emp.demo.enums.ErrEnum;
import com.example.emp.demo.enums.GenderEnum;
import com.example.emp.demo.model.EmpDB;
import com.example.emp.demo.repository.IempRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MethodService {


    @Autowired
    IempRepository iempRepository;

    /**
     * 查找id
     *
     * @param id
     * @throws MesException
     */
    protected void checkId(Integer id) throws MesException {
        Optional<EmpDB> Eid = iempRepository.findAllById(id);
        if (!Eid.isPresent()) {
            throw new MesException(ErrEnum.MESSENGER3, "Not found");
        }


    }


    /**
     * 檢查性別輸入
     *
     * @param gender
     * @throws MesException
     */
    protected void checkGender(String gender) throws MesException {


        boolean isContainsGender = GenderEnum.contains(gender);

        if (!isContainsGender) {
            throw new MesException(ErrEnum.MESSENGER6, "格式錯誤");
        }
    }

    /**
     * 檢查部門
     * @param dept
     * @throws MesException
     */
    protected void chekDept(String dept) throws MesException {

        boolean checkDeptno = DeptEnum.containDept(dept);

        if (!checkDeptno){
            throw new MesException(ErrEnum.MESSENGER7 , "輸入部門1-3");
        }
    }

}