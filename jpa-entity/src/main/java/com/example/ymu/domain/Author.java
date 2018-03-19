package com.example.ymu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-19 下午4:47
 * @updateTime
 * @since 1.0.0
 */
@Entity
public class Author extends BaseEntity {

    @Column(nullable = false, length = 80)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
