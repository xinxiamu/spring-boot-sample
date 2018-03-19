package com.example.ymu.dao.impl;

import com.example.ymu.dao.SchoolDao;
import com.example.ymu.dao.base.BaseDaoImpl;
import com.example.ymu.dao.repository.SchoolRepository;
import jooq.gen.testDb.tables.School;
import jooq.gen.testDb.tables.Teacher;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.stereotype.Repository;


@Repository
public class SchoolDaoImpl extends BaseDaoImpl<SchoolRepository> implements SchoolDao {

    @Override
    public String findSchoolName() {
		/*String userName = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3307/library";

		try (Connection conn = DriverManager.getConnection(url, userName, password)) {
			DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
			Result<Record> result = create.select().from(AUTHOR).fetch();

			for (Record r : result) {
				Integer id = r.getValue(AUTHOR.ID);
				String firstName = r.getValue(AUTHOR.FIRST_NAME);
				String lastName = r.getValue(AUTHOR.LAST_NAME);

				System.out.println("ID: " + id + " first name: " + firstName + " last name: " + lastName);
			}
		}

		// For the sake of this tutorial, let's keep exception handling simple
		catch (Exception e) {
			e.printStackTrace();
		}*/


        Result<Record> a = jooqDsl.select().from(School.SCHOOL).fetch();
        System.out.println("---sql:" + a.size());
        return a.get(0).get(School.SCHOOL.NAME);
    }

    @Override
    public String findSchoolInfo() {
        Result<Record> result = jooqDsl.select().from(School.SCHOOL).crossJoin(Teacher.TEACHER).where(School.SCHOOL.ID.eq(Teacher.TEACHER.SCHOOL_ID)).fetch();
        System.out.println("=====>>>" + result.size());
        return "size=" + result.size();
    }

}
