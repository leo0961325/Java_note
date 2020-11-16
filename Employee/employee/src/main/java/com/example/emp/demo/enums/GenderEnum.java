package com.example.emp.demo.enums;

public enum GenderEnum {


    GENDER_MAN("Male"),
    GENDER_WOMAN("Female");



    String empGender ;


    GenderEnum(String empGender) {
        this.empGender = empGender;

    }

    public static boolean contains(String gender) {

        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.empGender.equals(gender)) {
                return true;
            }
        }

        return false;
    }

    public String getEmpGender(){

        return this.empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }
}
