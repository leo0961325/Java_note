package com.example.store.demo.model;

import com.example.store.demo.storeRequest.UserRequest;
import com.example.store.demo.storeRequest.UserRequests;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User<group> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name = "dept")
    private String dept;
    @Column(name = "email")
    private String email;
    @Column(name = "point")
    private int point;


    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name="detail_id" ,referencedColumnName="id")
    private Detail detail;

    /**
     *  Merge 合併修改連動
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="group_id")
    private Group group;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name="user_project",joinColumns= {@JoinColumn(name="user_id")},inverseJoinColumns= {@JoinColumn(name="project_id")})
    private List<Project> projects;



    public User() {
    }



    public User(UserRequest userRequest) {
        this.name = userRequest.getName();
        this.dept = userRequest.getDept();
        this.email= userRequest.getEmail();
        this.point = userRequest.getPoint();

    }




    //omit gets and sets


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setGroup(List<Group> group) {
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

