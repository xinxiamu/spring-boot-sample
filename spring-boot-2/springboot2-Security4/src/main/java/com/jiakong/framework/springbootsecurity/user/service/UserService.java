package com.jiakong.framework.springbootsecurity.user.service;

import com.jiakong.framework.springbootsecurity.user.entity.SysUser;
import com.jiakong.framework.springbootsecurity.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserService
 *
 * @author yangpeng
 * @date 2018-05-22-17
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public SysUser findByName(String username) {
        SysUser user = userRepository.findByName(username);
        return user;
    }

    public void update(SysUser su) {
        userRepository.save(su);
    }
}
