package com.example.store.demo.storeResponse;

import com.example.store.demo.model.StoreDb;
import com.example.store.demo.storeRequest.StoreRequest;

public class StoreResponse {

    Integer id;
    String number;
    String name;
    String code;
    Integer price;
    String status;


    /**
     * Constructor
     */
    public StoreResponse() {
    }

    public StoreResponse(StoreDb storeDb) {

        this.id = storeDb.getId();
        this.number = storeDb.getNumber();
        this.name = storeDb.getName();
        this.code = storeDb.getCode();
        this.price = storeDb.getPrice();
        this.status = storeDb.getStatus();

        if (this.status.equals("1")) { /***/
            this.status = "啟用中";
        }

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
