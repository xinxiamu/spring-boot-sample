package com.jiakong.framework.springbootsecurity.config;

import com.jiakong.framework.springbootsecurity.user.entity.SysUser;
import com.jiakong.framework.springbootsecurity.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * CustomUserDetailsService
 *
 * @author yangpeng
 * @date 2018-05-22-16
 */
@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userService.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("userName" + username + "not found");
        }
        SecurityUser securityUser = new SecurityUser(user);
        return securityUser;
    }
}
