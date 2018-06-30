package com.jiakong.framework.springbootsecurity.user.repository;

import com.jiakong.framework.springbootsecurity.user.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author yangpeng
 * @date 2018-05-22-18
 */
public interface UserRepository extends JpaRepository<SysUser, Long> {
    /**
     * 根据用户名查询
     *
     * @param name
     * @return
     */
    SysUser findByName(String name);
}
