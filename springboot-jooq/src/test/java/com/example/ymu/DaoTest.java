package com.example.ymu;

import com.example.ymu.dao.*;
import com.example.ymu.domain.*;
import com.example.ymu.domain.type.PrincipalType;
import com.example.ymu.domain.type.SexType;
import org.jooq.Record;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;

import static jooq.generated.Tables.PEPOLE_BASIC;
import static jooq.generated.Tables.SCHOOL;


@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("prod")
@Transactional
public class DaoTest {


	@Autowired
	private SchoolDao schoolDao;
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private PepoleBasicDao pepoleBasicDao;
	@Autowired
	private PrincipalDao principalDao;

	@Test
	@Commit
	public void addSchool() {
		School school = new School();
		school.setAddr("马槛村");
		school.setFoundTime(new Date(System.currentTimeMillis()));
		school.setName("马槛小学");

		// 一年级
		Grade grade = new Grade();
		grade.setGnum(1);
		//两个班
		Classz class1 = new Classz();
		class1.setCnum(1);
		Classz class2 = new Classz();
		class2.setCnum(2);
		grade.addClass(class1);
		grade.addClass(class2);
		// 二年级
		Grade grade2 = new Grade();
		grade2.setGnum(2);
		//一个班
		Classz class3 = new Classz();
		class3.setCnum(1);
		grade2.addClass(class1);

		school.getGrades().add(grade);
		school.getGrades().add(grade2);

		schoolDao.getMRepository().save(school);
	}

	@Test
	public void getSchool() {
//		School school = schoolDao.getMRepository().findOne(1L);
//		System.out.println("=====school:" + school.getName());
//		schoolDao.findSchoolName();

		Result<Record> a = schoolDao.getJooq().select().from(SCHOOL).fetch();
		System.out.println("---sql:" + a.size());
	}

	@Test
	@Commit
	public void addTeacher() {
		Teacher teacher = new Teacher();
		teacher.setSchool(schoolDao.getMRepository().findOne(1L));
		PepoleBasic pepoleBasic = new PepoleBasic();
		pepoleBasic.setBirthdayTime(new java.util.Date());
		pepoleBasic.setName("张三");
		pepoleBasic.setSextType(SexType.MALE);
		pepoleBasicDao.getMRepository().save(pepoleBasic);
		teacher.setPepoleBasic(pepoleBasic);
		teacherDao.getMRepository().save(teacher);
	}

	@Test
	public void getPepoleTest() {
		Result<Record3<String, java.util.Date, String>> a = pepoleBasicDao.getJooq().select(PEPOLE_BASIC.NAME, PEPOLE_BASIC.BIRTHDAY_TIME, PEPOLE_BASIC.SEXT_TYPE).from(PEPOLE_BASIC).fetch();
		System.out.println("---a:" + a.size());
		for (Record3 r : a) {
			System.out.println(r.get(0));
		}
	}

	@Test
	@Commit
	public void addPrincipal() {
		Principal principal = new Principal();
		principal.setPrincipalType(PrincipalType.POSITIVE_LEVEL);
		principal.setTeacher(teacherDao.getMRepository().findOne(5L));
		principalDao.getMRepository().save(principal);
	}

	@Test
	public void test() {
	    System.out.println(">>>>>>>>");

		/*String userName = "root";
		String password = "root";
		String url = "jdbc:mysql://localhost:3307/library";

		// Connection is the only JDBC resource that we need
		// PreparedStatement and ResultSet are handled by jOOQ, internally
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
	}

	@Autowired
	private AuthorDao authorDao;

    @Autowired
	private BookDao bookDao;

    @Test
    @Commit
    public void addAuthorAndBooks() {
        Author author = new Author();
        author.setName("zmt");
        authorDao.getMRepository().save(author);

        Book book1 = new Book();
        book1.setAuthorId(author.getId());
        book1.setBookName("black world1");

        Book book2 = new Book();
        book2.setAuthorId(author.getId());
        book2.setBookName("haha1");

        Book book3 = new Book();
        book3.setAuthorId(author.getId());
        book3.setBookName("oo1");

        bookDao.getMRepository().save(book1);
        bookDao.getMRepository().save(book2);
        bookDao.getMRepository().save(book3);

    }
}
