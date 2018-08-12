package com.example.ymu.controller;

import com.example.ymu.dao.BookDao;
import com.example.ymu.dao.SchoolDao;
import com.example.ymu.domain.vo.VBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-17 下午4:27
 * @updateTime
 * @since 1.0.0
 */
@RestController
public class TestController {

    @Autowired
    private SchoolDao schoolDao;

    @Autowired
    private BookDao bookDao;

    @GetMapping("/test")
    public String test() {
        String schoolName = schoolDao.findSchoolName();
        System.out.println("schoolName:" + schoolName);
        System.out.println(">>>>" + schoolDao.getMRepository().findOne(1L).getName());
        return schoolDao.findSchoolInfo();
    }

    @GetMapping("/book/{id}")
    public VBook getBookInfo(@PathVariable(name = "id") long id) {
        return bookDao.getBookInfo(id);
    }

    @GetMapping("/getBookNameById")
    public String getBookNameById(long id) {
        return bookDao.getBookNameById(id);
    }

    @GetMapping("/getBooksAll")
    public List<VBook> getBooksAll() {
        return bookDao.getAll();
    }
}
