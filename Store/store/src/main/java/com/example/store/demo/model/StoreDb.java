package com.example.store.demo.model;

import com.example.store.demo.storeRequest.StoreRequest;
import com.example.store.demo.storeResponse.StoreResponse;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "store")
public class StoreDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "auto_increment")
    @GenericGenerator(name = "auto_increment", strategy = "native")
    private Integer id;


    @Column(name = "number")
    private String number;
    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "price")
    private Integer price;
    @Column(name = "status ")
    private Static status;

    public StoreDb() {
    }

    /**
     * 建構式要造一個一模一樣
     */
    public StoreDb(StoreRequest storeRequest) {
        this.number = storeRequest.getNumber();
        this.name = storeRequest.getName();
        this.code = storeRequest.getCode();
        this.price = storeRequest.getPrice();
        this.status = Static.CREATE; /**status 預設調為1 條件設定在 response*/

    }

    public static StoreDb StoreDbMethod(StoreRequest storeRequest, StoreDb storeDb){

            if (storeRequest.getName() != null) {
                storeDb.setName(storeRequest.getName());}
            if (storeRequest.getCode() != null){
                storeDb.setCode(storeRequest.getCode());}
            if (storeRequest.getNumber()!= null){
                storeDb.setNumber(storeRequest.getNumber());}
            if (storeRequest.getPrice() != null){
                storeDb.setPrice(storeRequest.getPrice());}

            return storeDb;

    }


    public enum Static{
        CREATE("啟用中"),
        DELETE("刪除");

        String code;

        /**
         * 建構式Constructor
         * @param code
         */
        Static(String code){
            this.code=code;
        }
        public String getStatic(){
            return this.code;
        }
    }



    public Integer getId() {
        return id;
    }

    public StoreDb setId(Integer id) {
        this.id = id;
        return null;
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

    public Static getStatus() {
        return status;
    }

    public void setStatus(Static status) {
        this.status = status;
    }
}

