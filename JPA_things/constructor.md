# Constructor 建構式


- 從UserResponse 去覆寫 User 定義的
```java
package com.example.demo.demo.response;

import com.example.demo.demo.model.User;

public class UserResponse {

    String name;
    String dept;
    String email;
    int point;


    /**
    *建構式複寫
    */
    public UserResponse() {
    }

    public UserResponse(User user) {

        this.name = user.getName();
        this.dept = user.getDept();
        this.email = user.getEmail();
        this.point = user.getPoint();

    }
    /***/

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
}
```
---
- Repository (I) 三種查詢方法 
``` java
@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
                                                      /**因為這裡是User所以要轉UserResponse*/
    Optional<User> findAllById(Integer id); //JPA

    @Query(value= "SELECT * FROM user ",nativeQuery=true)
    List<UserResponse> findAllySQL();  //SQL

    @Query(value= "SELECT u FROM User u")
    List<UserResponse> findAllByJPQL();  //JPQL抓物件
}
```
---
- UserService層
``` java
@Override
    public List<UserResponse> findData() {


        List<UserResponse> responses=new ArrayList<>(); //定義一個responses 的list {1}
        List<UserResponse> findAll = iuserRepository.findAllByJPQL();

        return findAll;
    }

```

- 記得回傳值都要改成Response!
