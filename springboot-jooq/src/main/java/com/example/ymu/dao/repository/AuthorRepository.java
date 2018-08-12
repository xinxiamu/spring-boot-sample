package com.example.ymu.dao.repository;

import com.example.ymu.dao.base.BaseRepository;
import com.example.ymu.domain.Author;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorRepository extends BaseRepository<Author, Long>,JpaSpecificationExecutor<Author> {

}
