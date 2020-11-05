# About Page

- IUserRepository (I)
``` java

@Query(value= "SELECT u FROM User u")s
    Page<UserResponse> findPageByJPQL(Pageable pageable);
```
- IUserService (I)
``` java
Page<UserResponse> findDataPPage(@RequestParam("page") Integer page,
                                @RequestParam("size") Integer size);
                        
```

- UserService
```java
 @Override
    public Page<UserResponse> findDataPPage(@RequestParam("page") Integer page,
                                            @RequestParam("size") Integer size) {



        Pageable pageable =PageRequest.of(page,size);
        Page<UserResponse> findAll = iuserRepository.findPageByJPQL(pageable);


        return findAll;
```

- UserController 
``` java
 @GetMapping(value = "user/page")
    public Page<UserResponse> pages(@RequestParam("page") Integer page,
                                    @RequestParam("size") Integer size){




        return iUserService.findDataPPage(page,size);
    }
```
