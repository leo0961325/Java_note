package com.example.nba.demo.controller.nbaException;

import com.example.nba.demo.enums.ErrorEnum;

public class NbaException extends Exception{


        private ErrorEnum errorCode;
        private String errorMessage;



        public NbaException(ErrorEnum errorCode , String errorMessage){
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

    public ErrorEnum getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorEnum errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
