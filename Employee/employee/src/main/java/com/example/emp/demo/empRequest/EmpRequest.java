package com.example.emp.demo.empRequest;

import com.example.emp.demo.enums.GenderEnum;
import com.sun.istack.NotNull;

public class EmpRequest {

    @NotNull
    String empId;
    @NotNull
    String dept;
    @NotNull
    String name;
    @NotNull
    String gender;
    @NotNull
    String status;
    @NotNull
    Integer id ;

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
