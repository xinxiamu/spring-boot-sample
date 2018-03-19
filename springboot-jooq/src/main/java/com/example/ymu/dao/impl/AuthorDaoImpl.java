package com.example.ymu.dao.impl;

import com.example.ymu.dao.AuthorDao;
import com.example.ymu.dao.SchoolDao;
import com.example.ymu.dao.base.BaseDaoImpl;
import com.example.ymu.dao.repository.AuthorRepository;
import com.example.ymu.dao.repository.SchoolRepository;
import jooq.gen.testDb.tables.School;
import jooq.gen.testDb.tables.Teacher;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;


@Repository
public class AuthorDaoImpl extends BaseDaoImpl<AuthorRepository> implements AuthorDao {


}
