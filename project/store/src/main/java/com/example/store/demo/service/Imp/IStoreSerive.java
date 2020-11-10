package com.example.store.demo.service.Imp;


import com.example.store.demo.model.StoreDb;
import com.example.store.demo.repository.IStoreRepository;
import com.example.store.demo.service.IStoreService;
import com.example.store.demo.storeRequest.StoreRequest;
import com.example.store.demo.storeResponse.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import sun.font.TrueTypeFont;

import java.util.List;
import java.util.Optional;

@Service
public class IStoreSerive implements IStoreService {

    @Autowired
    IStoreRepository iStoreRepository;

    /**
     * @param storeRequest 使用Db建構式
     * @return
     */


    @Override
    public StoreResponse post(StoreRequest storeRequest) throws Exception {

        Optional<StoreDb> tmp = iStoreRepository.findByCode(storeRequest.getCode());
        if(tmp.isPresent())
        {
            throw  new Exception("重複了");
        }
        StoreDb storeDb = new StoreDb(storeRequest); /**也是取用自*/


        iStoreRepository.save(storeDb); /**主要是這個存進資料庫*/
        StoreResponse response = new StoreResponse(storeDb);


        return response;
    }

    /**
     * @param id 找尋名字
     * @return 找尋
     */
    @Override
    public String get(Integer id) {

        Optional<StoreDb> allByID = iStoreRepository.findAllById(id);

        return allByID.get().getName();
    }


    /**
     * 分頁找資料
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<StoreResponse> findbypage(@RequestParam("page") Integer page,
                                          @RequestParam("size") Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<StoreResponse> findAll = iStoreRepository.findpagebyJPQL(pageable);


        return findAll;
    }

    /**
     * 從id找資料，如果沒有的話 回傳 Error
     *
     * @param id
     * @return
     */
    @Override
    public StoreResponse findAllData(Integer id) throws Exception {


        Optional<StoreResponse> findAllbyID = iStoreRepository.findByJPQL(id);
        if (!findAllbyID.isPresent()) {
            throw new Exception("Error");
        }
        return findAllbyID.get();
    }



    /***
     * 模糊查詢名字
     * */
    public List<StoreResponse> findNameData(String name){

        List<StoreResponse> findName = iStoreRepository.findAllBYName(name);



        return findName;

    }

    /**
     * 正確查詢 code一定要一模一樣
     * */

    public List<StoreResponse> findCodeData(String code){

        List<StoreResponse> findCode = iStoreRepository.findAllByCode(code);

        return findCode;
    }

    /**
     * 同時查詢name & code
     * @param name
     * @param code
     * @return 找出兩個，那如果是空值就全部列出來
     */
    public List<StoreResponse> findCodeAndNames(String name , String code){


        /****/ code = (code.isEmpty())?"%":code; /****/

        List<StoreResponse> findBoth = iStoreRepository.findAllByNameAndCode(name,code);



        return findBoth;
    }



    /**
     * 修改資料，只更改有更新的部分
     *
     * @param storeRequest StoreDbMethod
     * @return
     */
    @Override
    public String modify(StoreRequest storeRequest) {
        /**找出要修改第幾筆*/
        Optional<StoreDb> modifyThing = iStoreRepository.findAllById(storeRequest.getId());

        StoreDb storeDb = modifyThing.get();


        storeDb = StoreDb.StoreDbMethod(storeRequest, storeDb); /**把StoreDB 的method叫出來*/


        iStoreRepository.save(storeDb);


        return "已經修改完成!";
    }

    /**
     * 已經徹底刪除
     *
     * @param id
     * @return
     */
    @Override
    public String deleteTotally(@RequestParam("id") Integer id) {

        Optional<StoreDb> allById = iStoreRepository.findAllById(id);
        StoreDb storeDb = allById.get();

        iStoreRepository.delete(storeDb);


        return "已經徹底刪除";


    }

    /**
     * 暫時刪除
     *
     * @param id
     * @return
     */
    @Override
    public String deleteTem(@RequestParam("id") Integer id) {

        Optional<StoreDb> delByid = iStoreRepository.findAllById(id);

        StoreDb storeDb = delByid.get();

        storeDb.setStatus("00");

        iStoreRepository.save(storeDb);


        return "已經暫時刪除";
    }



}


