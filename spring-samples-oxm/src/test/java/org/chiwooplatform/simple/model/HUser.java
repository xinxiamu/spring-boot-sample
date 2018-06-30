package org.chiwooplatform.simple.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PO_GET_REGION_USERS_ITEM")
public class HUser {

    @XmlElement
    private String EMPLOYEE_NUM;

    @XmlElement
    private String EMPLOYEE_NAME;

    @XmlElement
    private String REGION_NAME;

    @XmlElement
    private String REGION_CODE;

    public String getEMPLOYEE_NUM() {
        return EMPLOYEE_NUM;
    }

    public void setEMPLOYEE_NUM(String EMPLOYEE_NUM) {
        this.EMPLOYEE_NUM = EMPLOYEE_NUM;
    }

    public String getEMPLOYEE_NAME() {
        return EMPLOYEE_NAME;
    }

    public void setEMPLOYEE_NAME(String EMPLOYEE_NAME) {
        this.EMPLOYEE_NAME = EMPLOYEE_NAME;
    }

    public String getREGION_NAME() {
        return REGION_NAME;
    }

    public void setREGION_NAME(String REGION_NAME) {
        this.REGION_NAME = REGION_NAME;
    }

    public String getREGION_CODE() {
        return REGION_CODE;
    }

    public void setREGION_CODE(String REGION_CODE) {
        this.REGION_CODE = REGION_CODE;
    }

    @Override
    public String toString() {
        return "HUser{" +
                "EMPLOYEE_NUM='" + EMPLOYEE_NUM + '\'' +
                ", EMPLOYEE_NAME='" + EMPLOYEE_NAME + '\'' +
                ", REGION_NAME='" + REGION_NAME + '\'' +
                ", REGION_CODE='" + REGION_CODE + '\'' +
                '}';
    }
}
