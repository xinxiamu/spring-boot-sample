package com.example.springmvcapiexport;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lujijiang on 2016/11/26.
 */
public class Webs {
    public static final String JSONP_CALLBACK_NAME = "jsonpcallback";

    /**
     * 从response对象获取字符流写入器，无论response是否被调用过getOutputStream
     *
     * @param response
     * @return
     * @throws IOException
     */
    public static PrintWriter getWriter(HttpServletResponse response)
            throws IOException {
        try {
            return response.getWriter();
        } catch (Exception e) {
            return new PrintWriter(response.getOutputStream());
        }
    }

    /**
     * 获取访问者的IP地址
     * @return
     */
    public static String getIP() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        if(request==null){
            throw new IllegalStateException("Need to configure the RequestContextListener");
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip==null || "".equals(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip==null || "".equals(ip)  || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip==null || "".equals(ip)  || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 多个路由时，取第一个非unknown的ip
        String[] ss = ip.split(",");
        for (String s : ss) {
            if (!"unknown".equalsIgnoreCase(s)) {
                ip = s;
                break;
            }
        }
        return ip;
    }
}
