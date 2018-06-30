package com.jiakong.framework.springbootsecurity.user.repository;

import com.jiakong.framework.springbootsecurity.user.entity.SysResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * SysResourceRpository
 *
 * @author yangpeng
 * @date 2018-05-23-09
 */
public interface SysResourceRpository extends JpaRepository<SysResource, Long> {

    @Query("select s from SysResource s where s.resourceName = ?1")
    List<SysResource> findByName(String s);
}
