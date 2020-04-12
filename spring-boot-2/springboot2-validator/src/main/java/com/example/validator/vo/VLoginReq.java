package com.example.validator.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class VLoginReq implements Serializable {

    /**
     * 登录用户名或者手机号码。
     */
    @NotBlank
    @Size(max = 8)
    private String username;

    /**
     * 登录密码。
     */
    @Size(min=8, max=30)
    private String password;

    /**
     * 是否记住我
     */
    private boolean isRememberMe;

    /**
     * 记住我天数。
     */
    private int rememberMeDay;
}
