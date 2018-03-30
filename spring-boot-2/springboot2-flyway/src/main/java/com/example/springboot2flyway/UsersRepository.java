package com.example.springboot2flyway;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-27 下午7:54
 * @updateTime
 * @since 1.0.0
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

}