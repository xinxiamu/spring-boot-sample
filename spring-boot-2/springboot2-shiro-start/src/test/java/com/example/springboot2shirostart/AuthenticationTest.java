package com.example.springboot2shirostart;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * 简单认证
 */
public class AuthenticationTest {

    SimpleAccountRealm simpleAccoutRealm = new SimpleAccountRealm();

    @Before
    public void addUser() {
//        simpleAccoutRealm.addAccount("zmt","123456");
//        simpleAccoutRealm.addAccount("zmt1","123456");

        simpleAccoutRealm.addAccount("zmt","123456","admin","user"); //添加角色
    }

    @Test
    public void  testAuthentication() {
        //1.创建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccoutRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zmt","123456");
        subject.login(token);
        System.out.println("isAuthenticated:" + subject.isAuthenticated());//已认证

        subject.checkRole("admin"); //admin通过，admin1报错
        subject.checkRoles("admin","user1"); //拥有该两个角色

//        subject.logout();//退出登录
//        System.out.println("isAuthenticated:" + subject.isAuthenticated());//未认证

    }


}
