package com.example.store.demo.enums;

public enum  DemoEnum {

    ERROR_MES("wrong"),
    ERROR_MES2("wrong2"),
    ERROR_MES3("empty data"),
    ERROR_MES4("demo001","ID not found"),
    ERROR_MES5("ID 長度不對"),
    ERROR_MES6("無此群組")
    ;

    String code;

    String message;

    DemoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    DemoEnum(String code){

        this.code = code;
    }

    public String getCode(){

        return this.code;
    }

}
