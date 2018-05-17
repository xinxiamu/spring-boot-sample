package com.example.springmvcapiexport.controller;

import java.io.Serializable;

public class ParVO1 implements Serializable {


    /**
     * taskType : All
     * taskStatus : All
     * matchType : All
     * queryDateType : bill
     * checkType : All
     * msfCheck : All
     * clientIsVip : All
     * beginDate : 2018-02-13 00:00:00
     * endDate : 2018-05-16 23:59:59
     */

    private String taskType;
    private String taskStatus;
    private String matchType;
    private String queryDateType;
    private String checkType;
    private String msfCheck;
    private String clientIsVip;
    private String beginDate;
    private String endDate;

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getQueryDateType() {
        return queryDateType;
    }

    public void setQueryDateType(String queryDateType) {
        this.queryDateType = queryDateType;
    }

    public String getCheckType() {
        return checkType;
    }

    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    public String getMsfCheck() {
        return msfCheck;
    }

    public void setMsfCheck(String msfCheck) {
        this.msfCheck = msfCheck;
    }

    public String getClientIsVip() {
        return clientIsVip;
    }

    public void setClientIsVip(String clientIsVip) {
        this.clientIsVip = clientIsVip;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
