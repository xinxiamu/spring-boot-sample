package com.example.springboot2ehcache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-21 下午6:03
 * @updateTime
 * @since 1.0.0
 */
@Repository
@CacheConfig(cacheNames = "GoodsType")
public class GoodsTypeDaoImpl {

    @Cacheable
    public String save(String typeId) {
        System.out.println("save()执行了=============");
        return "模拟数据库保存";
    }

    @CachePut
    public String update(String typeId) {
        System.out.println("update()执行了=============");
        return "模拟数据库更新";
    }

    @CacheEvict
    public String delete(String typeId) {
        System.out.println("delete()执行了=============");
        return "模拟数据库删除";
    }

    @Cacheable
    public String select(String typeId) {
        System.out.println("select()执行了=============");
        return "模拟数据库查询";
    }
}
