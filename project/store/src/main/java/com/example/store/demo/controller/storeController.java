package com.example.store.demo.controller;

import com.example.store.demo.model.StoreDb;
import com.example.store.demo.service.IStoreService;
import com.example.store.demo.storeRequest.StoreRequest;
import com.example.store.demo.storeResponse.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class storeController {

    @Autowired
    IStoreService iStoreService;


    /**新增一筆資料進DB*/
    @PostMapping(value = "post_item")
    public StoreResponse postItem(@RequestBody StoreRequest storeRequest) throws Exception {
            /**StoreDb是前端or Postman*/


        return iStoreService.post(storeRequest);
    }

    /**
     *
     * @param id
     * @return 特定的資料
     */
    @GetMapping(value = "get_value")
    public String GetItem(Integer id){



        return iStoreService.get(id);

    }
    /**分頁獲得資料*/
    @GetMapping(value = "pages")
    public Page<StoreResponse> Pages(@RequestParam("page") Integer page,
                                     @RequestParam("size") Integer size){


        return iStoreService.findbypage(page,size);
    }

    /**列出單筆全部資料*/
    @GetMapping(value = "get_list")
    public StoreResponse getList(Integer id) throws Exception {




        return iStoreService.findAllData(id);
    }


    /**
     * 找出模糊比對 name
     */
    @GetMapping(value = "find_name")
    public List<StoreResponse> findnameData(@RequestParam String name){

        return iStoreService.findNameData(name);
    }


    /**完全比對code要一模一樣*/
    @GetMapping(value = "find_code")
    public List<StoreResponse> findCodeData(@RequestParam String code){



        return iStoreService.findCodeData(code);
    }
    @GetMapping(value = "find_both")
    public List<StoreResponse> findCodeAndName(@RequestParam String name,
                                               @RequestParam String code){



        return iStoreService.findCodeAndNames(name,code);
    }




    /**
     * 修改該id所要修改的資料
     * @param storeRequest
     * @return
     */
    @PutMapping(value = "put")
    public String modifyData(@RequestBody StoreRequest storeRequest){


        String modify = iStoreService.modify(storeRequest);
        System.out.println(modify);
        return modify;
    }



    /**
     * 徹底刪除部分*/
    @DeleteMapping(value = "delete_all")
    public String delete(@RequestParam("id") Integer id){

        return iStoreService.deleteTotally(id);
    }
    /**
     * 暫時刪除的部分*/
    @DeleteMapping(value = "delete_tem")
    public String deleteTem(@RequestParam("id") Integer id){


        return iStoreService.deleteTem(id);
    }

}
