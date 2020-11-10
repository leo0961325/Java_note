package com.example.store.demo.repository;

import com.example.store.demo.model.StoreDb;
import com.example.store.demo.storeRequest.StoreRequest;
import com.example.store.demo.storeResponse.StoreResponse;
import org.hibernate.sql.Select;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStoreRepository extends JpaRepository<StoreDb, Integer> {


    /**
     * 判斷NUll的物件，裡面塞Db
     */
    Optional<StoreDb> findAllById(StoreRequest storeRequest);

    /**
     * 分頁做處理
     */
    @Query(value = "SELECT s FROM StoreDb s")
    Page<StoreResponse> findpagebyJPQL(Pageable pageable); //用建構式改成StoreResponse


    /**
     * 從ID找資料(全部)
     */
    @Query(value = "SELECT s FROM StoreDb s WHERE s.id = :id")
    Optional<StoreResponse> findByJPQL(Integer id);


    /**
     * 找尋特定資料
     */
    Optional<StoreDb> findAllById(Integer id);

    /**找尋code
     * @param code 回傳
     * */
    Optional<StoreDb> findByCode(String  code);

    @Query(value = "SELECT s FROM  StoreDb s WHERE s.name LIKE %:name%   ")
    List<StoreResponse> findAllBYName(String name);

    @Query(value = "SELECT s FROM  StoreDb s WHERE s.code = :code ")
    List<StoreResponse> findAllByCode(String code);

    @Query(value = "SELECT s FROM  StoreDb s WHERE s.status ='1'AND s.name LIKE %:name% AND s.code like :code" )
    List<StoreResponse> findAllByNameAndCode(String name, String code);
}
