package com.example.ymu.dao.repository;

import com.example.ymu.dao.base.BaseRepository;
import com.example.ymu.domain.Teacher;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRepository extends BaseRepository<Teacher, Long>,JpaSpecificationExecutor<Teacher> {

}
