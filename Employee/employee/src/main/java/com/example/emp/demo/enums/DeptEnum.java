package com.example.emp.demo.enums;

public enum DeptEnum {

    DEPT1("1"),
    DEPT2("2"),
    DEPT3("3");

    String deptno;

    DeptEnum(String deptno){
        this.deptno =deptno;
    }



    public static boolean contains(String gender) {

        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.empGender.equals(gender)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 檢查部門
     * @param Dept
     * @return
     */
    public static boolean containDept(String Dept){


        switch (Dept){
            case "3" :
                return true;
            case "2" :
                return true;

            case "1" :
                return true;
            default:
                return false;


        }
    }



    public String getDeptno(){
        return this.deptno;
    }

}
