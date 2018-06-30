package com.jiakong.framework.springbootsecurity.config;

import com.jiakong.framework.springbootsecurity.user.entity.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoginSuccessHandler
 *
 * @author yangpeng
 * @date 2018-05-22-17
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

    /**
     * //获得授权后可得到用户信息   可使用SUserService进行数据库操作
     * //输出登录提示信息
     *
     * @param request
     * @param response
     * @param authentication
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        SysUser userDetails = (SysUser) authentication.getPrincipal();
        logger.info("管理员" + userDetails.getName() + "登录");
        logger.info("IP" + getIpAddress(request));
        super.onAuthenticationSuccess(request, response, authentication);
    }

    private String getIpAddress(HttpServletRequest request) {
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
