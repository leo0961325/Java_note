package com.example.store.demo.service.Imp.methods;

import com.example.store.demo.controller.exceptions.DemoException;
import com.example.store.demo.storeRequest.StoreRequest;

import static com.example.store.demo.enums.DemoEnum.*;
import static com.example.store.demo.enums.DemoEnum.ERROR_MES4;

public class MethodService {

    /**
     * 分頁檢驗
     * @param page
     * @param size
     * @throws DemoException
     */
    protected void checkStorePage(Integer page , Integer size) throws DemoException {


        if ((page > 10)) {
            throw new DemoException(ERROR_MES ,"頁數過多");
        }

        if (size > 10) {
            throw new DemoException(ERROR_MES,"SIZE太多");
        }
    }

    /**
     * 更新的檢驗
     * @param storeRequest
     * @throws DemoException
     */
    protected void checkStoreDb(StoreRequest storeRequest) throws DemoException {
        String name = storeRequest.getName();
        if (name.isEmpty()) {
            throw new DemoException(ERROR_MES4);
        }
        String code = storeRequest.getCode();
        if ((code.length() < 2)) {
            throw new DemoException(ERROR_MES5);
        }
        Integer id = storeRequest.getId();
        if (id.equals(null)){
            throw new  DemoException(ERROR_MES4);

        }



    }


}
