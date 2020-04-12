package com.example.validator.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class VUserReq implements Serializable {

    /**
     * 登录用户名或者手机号码。
     */
    private String username;

    /**
     * 登录密码。
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    private Date creatTime;
}
