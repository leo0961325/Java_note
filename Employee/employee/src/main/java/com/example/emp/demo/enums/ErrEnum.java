package com.example.emp.demo.enums;

public enum ErrEnum {



    MESSENGER1("EMP ID already exist"),
    MESSENGER2("EMP ID Wrong format"),
    MESSENGER3("Data not found"),
    MESSENGER4("Already Deleted"),
    MESSENGER5("Status still Enable"),
    MESSENGER6("Please enter right sex"),
    MESSENGER7("Please enter dept 1-3");

    String code;
    String messenge;

    ErrEnum(String code , String messenge) {
        this.code = code;
        this.messenge = messenge;
    }

    ErrEnum(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    public String getMessenge() {
        return messenge;
    }
}
