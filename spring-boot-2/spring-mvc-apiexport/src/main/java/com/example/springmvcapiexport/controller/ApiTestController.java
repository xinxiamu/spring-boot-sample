package com.example.springmvcapiexport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能简述:<br>
 *
 * @author zmt
 * @create 2018-03-20 下午8:53
 * @updateTime
 * @since 1.0.0
 */
@RestController
@RequestMapping("/test")
public class ApiTestController {

    @GetMapping("/get")
    public String apiTestGet() {
        return "get";
    }

    @PostMapping("/post")
    public String apiTestPost() {
        return "post";
    }

    @RequestMapping()
    public String test() {
        return "index";
    }

}
