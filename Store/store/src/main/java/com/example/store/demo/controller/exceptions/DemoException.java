package com.example.store.demo.controller.exceptions;

import com.example.store.demo.enums.DemoEnum;

public class DemoException extends Exception {


    private DemoEnum errorcode;
    private String errorMessage;

    public DemoException(DemoEnum errorcode, String errorMessage) {
        this.errorcode = errorcode;
        this.errorMessage = errorMessage;

    }

    public DemoException(DemoEnum errorMes4) {
        errorcode = errorMes4;

    }

    public DemoEnum getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(DemoEnum errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
