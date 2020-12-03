package com.example.store.demo.controller.advice;


import com.example.store.demo.controller.exceptions.DemoException;
import com.example.store.demo.enums.DemoEnum;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DemoExceptionHandler {

    /**
     * 這裡處理要回傳的東西。
     * @param ex
     * @return
     */
    @ExceptionHandler({DemoException.class})
    public Map handleExption(DemoException ex){

        Map map = new HashMap();
        map.put("code : " , ex.getErrorcode());
        map.put("message : " , ex.getErrorMessage());

        return map;

    }

    /**
     * map <key : value> JSON
     * @param ex
     * @return
     */
    @ExceptionHandler({Exception.class})
    public Map handleExption(Exception ex){

        Map map = new HashMap();
        map.put("code : " , DemoEnum.ERROR_MES2);
        map.put("message : " , ex.getMessage());

        return map;

    }





}
