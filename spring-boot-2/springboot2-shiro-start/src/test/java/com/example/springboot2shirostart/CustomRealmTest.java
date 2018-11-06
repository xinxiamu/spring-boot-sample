package com.example.springboot2shirostart;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 简单认证
 */
public class CustomRealmTest {


    @Test
    public void  test1() {

        CustomRealm customRealm = new CustomRealm();//自定义Realm

        //1.创建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);

        //设置散列加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");//设置加密方式
        matcher.setHashIterations(1); //设置加密次数
        customRealm.setCredentialsMatcher(matcher); //设置加密对象

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zmt","e10adc3949ba59abbe56e057f20f883e");//用户,密码MD5加密。明文：123456
        subject.login(token);
        System.out.println("isAuthenticated:" + subject.isAuthenticated());//已认证

//        subject.checkRole("admin"); //admin通过，admin1报错
        subject.checkRoles("admin","user"); //拥有该两个角色

        //权限
        subject.checkPermission("user:select");//jdbcRealm.setPermissionsLookupEnabled(true);
//        subject.checkPermission("user:insert"); //报错，么有insert权限
        subject.checkPermission("user:update"); //有update权限
    }

    @Test
    public void genPwd() {
//        Md5Hash md5Hash = new Md5Hash("123456"); //md5加密密码，不加盐
//        System.out.println("md5加密：" + md5Hash);

        Md5Hash md5Hash = new Md5Hash("e10adc3949ba59abbe56e057f20f883e","aaa"); //md5加密密码，加盐，密码更加难以识破，盐一般用随机数，这里写死
        System.out.println("md5加盐加密：" + md5Hash);
    }



}
