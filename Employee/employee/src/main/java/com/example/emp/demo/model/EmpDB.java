package com.example.emp.demo.model;

import com.example.emp.demo.empRequest.EmpRequest;
import com.example.emp.demo.empRequest.PostRequest;
import com.example.emp.demo.enums.DeptEnum;
import com.example.emp.demo.enums.GenderEnum;
import com.example.emp.demo.enums.StatusEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "EmpDB")
public class EmpDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;


    @Column(name = "empId")
    private String empId;
    @Column(name = "dept")
    private String dept;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "status")
    private StatusEnum status;


    public EmpDB(){}

    public EmpDB(PostRequest postRequest){
        this.empId = postRequest.getEmpId();
        this.name  = postRequest.getName();
        this.dept =  postRequest.getDept();
        this.gender = postRequest.getGender();
        this.status = StatusEnum.ENABLE;

    }

    public  EmpDB EmpDbMethod(EmpRequest empRequest,  EmpDB empDB){

        if (empRequest.getDept() != null) {
            empDB.setDept(empRequest.getDept());}
        if (empRequest.getName() != null){
            empDB.setName(empRequest.getName());}
        if (empRequest.getEmpId()!= null){
            empDB.setEmpId(empRequest.getEmpId());}
        if (empRequest.getGender() != null){
            empDB.setGender((empRequest.getGender()));}

        return empDB;

    }










    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}













