package com.example.ymu.dao.repository;

import com.example.ymu.dao.base.BaseRepository;
import com.example.ymu.domain.School;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SchoolRepository extends BaseRepository<School, Long>,JpaSpecificationExecutor<School> {

}
