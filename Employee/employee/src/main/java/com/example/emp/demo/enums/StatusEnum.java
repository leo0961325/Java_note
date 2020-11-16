package com.example.emp.demo.enums;

public enum StatusEnum {

   ENABLE("啟用中"),
   UNABLE("已刪除"),
   Unknown("錯誤輸入信息");

   String status;

   StatusEnum(String status){
       this.status = status;
   }
   public String getStatus(){

       return this.status;
   }

}
