package com.example.store.demo.enums;

public enum StoreEnum {

    CREATE("已經創建"),
    DELETED("已經刪除");


    String statuss ;

    /**
     * 建構值
     * @param statuss
     */
    StoreEnum(String statuss) {
        this.statuss = statuss;
    }

    public String getStatuss() {
        return statuss;
    }
}
