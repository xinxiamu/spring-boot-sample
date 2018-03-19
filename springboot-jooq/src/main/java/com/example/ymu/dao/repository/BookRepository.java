package com.example.ymu.dao.repository;

import com.example.ymu.dao.base.BaseRepository;
import com.example.ymu.domain.Author;
import com.example.ymu.domain.Book;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends BaseRepository<Book, Long>,JpaSpecificationExecutor<Book> {

}
