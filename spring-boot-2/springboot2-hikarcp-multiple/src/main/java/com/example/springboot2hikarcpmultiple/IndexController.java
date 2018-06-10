package com.example.springboot2hikarcpmultiple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class IndexController {

    @Autowired
    private JdbcTemplate masterJdbcTemplate;
    @Autowired
    private JdbcTemplate slaveJdbcTemplate;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public List getUsers() {
        String sql = "SELECT * FROM users";
        List<Map<String, Object>> users = slaveJdbcTemplate.queryForList(sql);
        return users;
    }

    @GetMapping("/users/save")
    public boolean saveUser(String userName) {
        String sql = "INSERT INTO `users` (`username`, `first_name`, `last_name`) VALUES (?, '王1', '春海1')";
        masterJdbcTemplate.update(sql, userName);
        return true;
    }
}
