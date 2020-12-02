package com.example.nba.demo.controller.nbaExceptionHandler;


import com.example.nba.demo.controller.nbaException.NbaException;
import com.example.nba.demo.enums.ErrorEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class nbaExceptionHandler {




    @ExceptionHandler({NbaException.class})
    public Map handleException(NbaException ex){

        Map map = new HashMap();
        map.put("code" , ex.getErrorCode());
        map.put("message : " , ex.getErrorMessage());

        return map;
    }


    @ExceptionHandler({Exception.class})
    public Map handlerException(Exception ex){

        Map map = new HashMap();
        map.put("message : " ,ex.getMessage());

        return map;
    }





























}
