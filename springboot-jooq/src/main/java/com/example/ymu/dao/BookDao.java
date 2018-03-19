package com.example.ymu.dao;

import com.example.ymu.dao.base.BaseDao;
import com.example.ymu.dao.repository.AuthorRepository;
import com.example.ymu.dao.repository.BookRepository;
import com.example.ymu.domain.vo.VBook;

import java.util.List;

public interface BookDao extends BaseDao<BookRepository> {

    VBook getBookInfo(long bookId);

    List<VBook> getAll();

    String getBookNameById(long bookId);
}
