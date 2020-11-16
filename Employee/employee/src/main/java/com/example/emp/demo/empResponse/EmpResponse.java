package com.example.emp.demo.empResponse;

import com.example.emp.demo.enums.GenderEnum;
import com.example.emp.demo.model.EmpDB;

public class EmpResponse {


    String empId;
    String dept;
    String name;
    String gender;
    String status;
    Integer id;



    public EmpResponse(){}

    public EmpResponse(EmpDB empDB){
        this.empId = empDB.getEmpId();
        this.name = empDB.getName();
        this.dept = empDB.getDept();
        this.gender = empDB.getGender();
        this.status = empDB.getStatus().getStatus();
        this.id = empDB.getId();

    }



    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
