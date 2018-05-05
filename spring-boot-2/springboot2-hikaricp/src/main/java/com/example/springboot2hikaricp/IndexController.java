package com.example.springboot2hikaricp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class IndexController {

    @Value("${spring.datasource.url}")
    private String url;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/index")
    public String index() {
        return url;
    }

    @GetMapping("/users")
    public List getUsers() {
        String sql = "SELECT * FROM users";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql);
        return users;
    }

    @GetMapping("/users/save")
    public boolean saveUser() {
        String sql = "INSERT INTO `datebook`.`users` (`id`, `username`, `first_name`, `last_name`) VALUES ('3', '王春海1', '王', '春海')";
        jdbcTemplate.execute(sql);
        return true;
    }
}
