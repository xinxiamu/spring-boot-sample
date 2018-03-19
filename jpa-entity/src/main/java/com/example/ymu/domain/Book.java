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
public class Book extends BaseEntity {

    @Column(nullable = false,length = 150,unique = true)
    private String bookName;

    @Column
    private long authorId;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
