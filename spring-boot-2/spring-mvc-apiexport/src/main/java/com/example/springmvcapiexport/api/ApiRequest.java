package com.example.springmvcapiexport.api;

import java.io.Serializable;
import java.util.Arrays;

/**
 * post参数体：json格式。对应该bean结构。
 */
public class ApiRequest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -81070875483237596L;
    /**
     * 回调ID
     */
    String id;
    /**
     * 请求令牌
     */
    String token;
    /**
     * 服务名。格式：类名.方法名
     */
    String action;
    /**
     * 服务参数
     */
    Object[] args;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    @Override
    public String toString() {
        return "ApiRequest{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", action='" + action + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }
}
