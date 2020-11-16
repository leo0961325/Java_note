package com.example.emp.demo.controller.exceptions;

import com.example.emp.demo.enums.ErrEnum;

public class MesException extends  Exception{

    private ErrEnum errorcode;
    private  String errorMessage;


    public MesException(ErrEnum errorcode , String errorMessage){
        this.errorcode = errorcode;
        this.errorMessage =errorMessage;
    }

    public MesException(ErrEnum errorcode){

        this.errorcode = errorcode;
    }




    public ErrEnum getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(ErrEnum errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
