package com.example.emp.demo.service.IMP;

import com.example.emp.demo.controller.exceptions.MesException;
import com.example.emp.demo.empRequest.EmpRequest;
import com.example.emp.demo.empRequest.PostRequest;
import com.example.emp.demo.empResponse.EmpResponse;
import com.example.emp.demo.enums.DeptEnum;
import com.example.emp.demo.enums.ErrEnum;
import com.example.emp.demo.enums.GenderEnum;
import com.example.emp.demo.enums.StatusEnum;
import com.example.emp.demo.model.EmpDB;
import com.example.emp.demo.repository.IempRepository;
import com.example.emp.demo.service.IempService;
import com.example.emp.demo.service.mehods.MethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class empService extends MethodService implements IempService {


    @Autowired
    IempRepository iempRepository;

    /**
     * 使用者輸入資訊
     *
     * @param postRequest
     * @return
     * @throws MesException
     */
    @Override
    public EmpResponse post(PostRequest postRequest) throws MesException {

        checkEmpId(postRequest.getEmpId());

        checkGender(postRequest.getGender());

        chekDept(postRequest.getDept());

        Optional<EmpDB> exist = iempRepository.findByEmpId(postRequest.getEmpId());

        if (exist.isPresent()) {
            throw new MesException(ErrEnum.MESSENGER1, "this employee is already used");
        }

        EmpDB empDB = new EmpDB(postRequest);

        iempRepository.save(empDB);
        EmpResponse empResponse = new EmpResponse(empDB);

        return empResponse;
    }

    /**
     * 判斷身分證的格式
     *
     * @param empId
     * @throws MesException
     */
    private void checkEmpId(String empId) throws MesException {
        if (!empId.matches("[A-Z]\\d{9}")) {
            throw new MesException(ErrEnum.MESSENGER2, "輸入的格式錯誤");
        }

    }


    @Override
    public String deleteTemp(Integer id) throws MesException {
        Optional<EmpDB> deleteIdTem = iempRepository.findById(id);

        /**找到先CHECK*/checkId(id);
        EmpDB empDB = deleteIdTem.get();


        if (empDB.getStatus() != StatusEnum.ENABLE) {

            throw new MesException(ErrEnum.MESSENGER4, "資料早就被刪除");
        }

        empDB.setStatus(StatusEnum.UNABLE);
        iempRepository.save(empDB);

        return "已經暫時刪除了";
    }




    @Override
    public EmpResponse findAllData(Integer id) throws MesException {


        EmpDB empDB = cheackEmpId(id);


        return new EmpResponse(empDB);
    }

    private EmpDB cheackEmpId(Integer id) throws MesException {
        Optional<EmpDB> tmp = iempRepository.findAllById(id);
        if (!tmp.isPresent()) {
            throw new MesException(ErrEnum.MESSENGER3, "Not found");
        }
        return tmp.get();
    }


    @Override
    public String reStore(EmpRequest empRequest) throws MesException {

        Optional<EmpDB> reStore = iempRepository.findById(empRequest.getId());

        if (!reStore.isPresent()) {

            throw new MesException(ErrEnum.MESSENGER3, "找不到資料此筆ID");
        } else {
            EmpDB empDB = reStore.get();

            if (empDB.getStatus() == StatusEnum.UNABLE) {

                empDB.setStatus(StatusEnum.ENABLE);
                empDB = empDB.EmpDbMethod(empRequest, empDB);
                iempRepository.save(empDB);
            } else  {
                empDB = empDB.EmpDbMethod(empRequest, empDB);
                iempRepository.save(empDB);
                return "已經修改資料";
                //
                // throw new MesException(ErrEnum.MESSENGER5, "資料尚未被刪除");
            }
        }

        return "資料已經復原";
    }


    @Override
    public List<EmpResponse> findNameList(String name, Integer status) throws MesException {


        /**
         * 三源運算子無法
         */
        StatusEnum setStatus = (status.equals(StatusEnum.ENABLE.ordinal())) ? (StatusEnum.ENABLE) : StatusEnum.UNABLE;


        List<EmpResponse> findName = iempRepository.findAllBYNameAndStatus(name, setStatus);
        if (findName.isEmpty()) throw new MesException(ErrEnum.MESSENGER3, "找不到名字");


        return findName;

    }

    /**
     * 新增資料，如果沒有就新增資料，有的話回傳ID給下面reStoreExist
     * @param postRequest
     * @return
     * @throws MesException
     */
    @Override
    public String postIfEmpty(PostRequest postRequest) throws MesException {



        checkGender(postRequest.getGender());

        chekDept(postRequest.getDept());
        /***
         * 從exist取
         */
        Optional<EmpDB> exist = iempRepository.findByEmpId(postRequest.getEmpId());
        /**
         * 這裡報錯，因取取值在判斷之前
         */
        //StatusEnum status = exist.get().getStatus();
        /***/
        if (exist.isPresent() && exist.get().getStatus() == StatusEnum.ENABLE) {

            throw new MesException(ErrEnum.MESSENGER1 , "EMP ID 已建立");

        }
        else if (exist.isPresent()){
            Integer showId = exist.get().getId();
            return "ID是"+showId;
        }
        else {

            EmpDB empDB = new EmpDB(postRequest);
            iempRepository.save(empDB);

            return "新增資料完成";
        }


    }

    /**
     * 用這支去查詢
     * @param id
     * @return
     */
    @Override
    public String reStoreExist(Integer id) {

        Optional<EmpDB> exist = iempRepository.findById(id);

        EmpDB empDB = exist.get();
        empDB.setStatus(StatusEnum.ENABLE);
        iempRepository.save(empDB);



        return "復原完成";
    }


}






