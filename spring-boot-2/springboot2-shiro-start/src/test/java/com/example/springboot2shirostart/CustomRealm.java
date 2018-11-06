package com.example.springboot2shirostart;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {

    final String realmName = this.getClass().getSimpleName(); //自定义realm名称

    Map<String,String> userMap = new HashMap<>(16);

    {
//        userMap.put("zmt","123456");
//        userMap.put("zmt","e10adc3949ba59abbe56e057f20f883e"); //数据库的密码是密文，不加盐
        userMap.put("zmt","640a19b710290a9ff4d72e70cdd21913"); //md5加盐密码
        userMap.put("xr","654321");

        super.setName(realmName); //设置名称
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        //从数据库或者缓存中获取角色数据。
        Set<String> roles = getRolesByUsername(username);
        Set<String> permissions = getPermissionByUsername(username);

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissions); //设置权限
        authorizationInfo.setRoles(roles); //设置角色

        return authorizationInfo;
    }

    /**
     * 模拟通过用户名获取权限。
     * @param username
     * @return
     */
    private Set<String> getPermissionByUsername(String username) {
        Set<String> permissions = new HashSet<>();
        permissions.add("admin:delete");
        permissions.add("user:select");
        permissions.add("user:update");
        return permissions;
    }

    /**
     * 模拟获取角色。根据用户名获取角色。
     * @param username
     * @return
     */
    private Set<String> getRolesByUsername(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("admin");
        roles.add("user");
        return roles;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //从主体传过来认证信息,获得用户名
        String username = (String) token.getPrincipal();
        System.out.println("username:" + username);

        //通过用户名到数据库中获取凭证
        String pwd = getPwdByUsername(username);
        if (pwd == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,pwd,realmName);
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("aaa")); //密码加盐后，这里要加上这句

        return authenticationInfo;
    }

    /**
     * 模拟获取数据库数据。根据用户名获取用户密码
     * @param username 用户名。
     * @return
     */
    private String getPwdByUsername(String username) {
        return userMap.get(username);
    }


}
