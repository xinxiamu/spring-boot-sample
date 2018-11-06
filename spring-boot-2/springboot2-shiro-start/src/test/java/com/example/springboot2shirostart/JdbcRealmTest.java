package com.example.springboot2shirostart;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * 简单认证
 */
public class JdbcRealmTest {

    DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setUrl("jdbc:mysql://localhost:3307/shiro-test");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }

    /**
     * 查询默认的数据表做相关操作。
     * @see JdbcRealm
     */
    @Test
    public void  test1() {

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource); //设置数据源
        jdbcRealm.setPermissionsLookupEnabled(true); //是否可以查看权限。默认为false。不打开，则无法查看权限

        //1.创建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("zmt","123456");//用户
        subject.login(token);
        System.out.println("isAuthenticated:" + subject.isAuthenticated());//已认证

        subject.checkRole("admin"); //admin通过，admin1报错
//        subject.checkRoles("admin","user"); //拥有该两个角色

        //权限
        subject.checkPermission("user:select");//jdbcRealm.setPermissionsLookupEnabled(true);
//        subject.checkPermission("user:insert"); //报错，么有insert权限
//        subject.checkPermission("user:update"); //报错，没有update权限
    }

    @Test
    public void  test2() {

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource); //设置数据源
        jdbcRealm.setPermissionsLookupEnabled(true); //是否可以查看权限。默认为false。不打开，则无法查看权限

        //创建sql语句，使用自己的表、sql来验证
        String sql_auth = "SELECT `password` FROM test_user WHERE user_name = ?";
        jdbcRealm.setAuthenticationQuery(sql_auth);
        String sql_role = "SELECT role_name FROM test_user_role WHERE test_user_name = ?";
        jdbcRealm.setUserRolesQuery(sql_role);
        String sql_permisstion = "SELECT permission FROM test_role_permissions WHERE role_name = ?";
        jdbcRealm.setPermissionsQuery(sql_permisstion);

        //1.创建securityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("xr","123456");//用户
        subject.login(token);
        System.out.println("isAuthenticated:" + subject.isAuthenticated());//已认证

        subject.checkRole("caiwu");

        //权限
        subject.checkPermission("user:update");//jdbcRealm.setPermissionsLookupEnabled(true);
    }


}
