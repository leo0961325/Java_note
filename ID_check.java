package com.example.demo.demo.service.impl;

import com.example.demo.demo.request.PersonRequest;
import com.example.demo.demo.response.PersonResponse;
import com.example.demo.demo.service.IIdentifyService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class IdentifyService implements IIdentifyService {





//    @Override
//    public String identify(@RequestBody PersonRequest personRequest) {
//
//        PersonResponse response = new PersonResponse();
//
//
//        String name = personRequest.getName();
//        String id = personRequest.getId();
//
//        response.setName(name);
//        response.setId(id);
//
//
//
//
//        return ("Hi " + name + "您好，身分證字號為 : " + id);
//    }

    @Override
    public String identify(@RequestBody PersonRequest personRequest) {

        PersonResponse response = new PersonResponse();


        String name = personRequest.getName();
        String id = personRequest.getId();
        int idd = id.toUpperCase().charAt(1);
        idd = id.charAt(1)-'0';

        if(!id.matches("[A-Z]\\d{9}")) {                      //一個英文字加九個數字
            return id + " 輸入格式錯誤";
            //System.out.println("輸入格式錯誤！");
            //continue;
        }

        if(idd != 1 && idd != 2) {                                 //第一個數字為1或2
            return id +" 輸入格式錯誤";
            //System.out.println("輸入格式錯誤！");
            //continue;
        }

//驗證演算法是否正確
        String s = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
        int id00 = (s.indexOf(id.charAt(0))+10)/10;
        int id01 = (s.indexOf(id.charAt(0))+10)%10;
        int id9 = id.charAt(9)-'0';
        int sum = 0;

        for(int i=1,j=8;i<9;i++) {
            sum += (id.charAt(i)-'0')*j;
            j--;
        }
        sum = sum + id00*1 + id01*9;
        response.setName(name);
        response.setId(idd);
        String gender = idd == 1 ? "先生" : "小姐";
        if(sum%10 == 10-id9) {
            return ("Hi " + name + gender + "您好，身分證字號為 : " + id +" 您的身分證驗證正確");
            //break;
        }
        else if(sum%10==0 && id9==0) {
            return ("Hi " + name + gender + "您好，身分證字號為 : " + id +" 您的身分證驗證錯誤");
            //break;
        }
        else {
            return ("Hi " + name + gender + "您好，身分證字號為 : " + id +" 您的身分證驗證錯誤");
            //break;
        }

//        response.setName(name);
//        response.setId(idd);
//        String gender = idd == 1 ? "先生" : "小姐";
//        return ("Hi " + name + gender + "您好，身分證字號為 : " + id);
}


    }



