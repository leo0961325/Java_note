package com.example.emp.demo.controller.advice;


import com.example.emp.demo.controller.exceptions.MesException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({MesException.class})
    public Map handleException(MesException ex){

        Map map = new HashMap();
        map.put("Errorcode : " , ex.getErrorcode());
        map.put("ErrorMessage : " , ex.getErrorMessage());

        return map;
    }




}
